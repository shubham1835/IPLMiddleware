package com.ipl.middleware;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.ipl.middleware.utils.Util;

import java.io.*;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.util.*;

public final class Test {
    private static final String APPLICATION_NAME = "Google Drive API project";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final String PathToServiceAccountKeyFile = "/drive-project-323207-cd2f4d5c7202.json";
    private static final String ServiceAccountEmail = "drive-account-256@drive-project-323207.iam.gserviceaccount.com";
    private static final String UploadFileName = "Test hello.txt";
    private static final String DirectoryId = "1V0UvJ4f7PjFXCaN-b_3GeIrTWBmo8A49";

    private Test() {
    }

    ;

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE_METADATA_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream keyInputStream = Test.class.getResourceAsStream(PathToServiceAccountKeyFile);
        if (keyInputStream == null) {
            throw new FileNotFoundException("Resource not found: " + PathToServiceAccountKeyFile);
        }

        GoogleCredential credential = GoogleCredential.fromStream(keyInputStream)
                .createScoped(Collections.singleton(DriveScopes.DRIVE));
        return credential;
//        InputStream in = Test.class.getResourceAsStream(PathToServiceAccountKeyFile);
//        if (in == null) {
//            throw new FileNotFoundException("Resource not found: " + PathToServiceAccountKeyFile);
//        }
//        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
//
//        // Build flow and trigger user authorization request.
//        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
//                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
//                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
//                .setAccessType("offline")
//                .build();
//        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
//        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public static String getGoogleAuthenticatorBarCode(String secret) {
        try {
            return "otpauth://totp/"
                    + URLEncoder.encode("AV-Ecommerce" + ":" + "Shub1835", "UTF-8").replace("+", "%20")
                    + "?secret=" + URLEncoder.encode(secret, "UTF-8").replace("+", "%20")
                    + "&issuer=" + URLEncoder.encode("AV-Ecommerce", "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }


    public static void main(String[] as) throws GeneralSecurityException, IOException, InterruptedException {
//        InputStream states = Thread.currentThread().getContextClassLoader().getResourceAsStream("states.json");
//
//        String statesJson = new BufferedReader(
//                new InputStreamReader(states, StandardCharsets.UTF_8))
//                .lines().collect(Collectors.joining("\n"));
//        JSONObject obj = new JSONObject(statesJson);
//        JSONObject mainObj = new JSONObject();
//        JSONArray allObj = obj.getJSONArray("List Of Cities And Towns In Ind");
//        allObj.iterator().forEachRemaining(stateObj -> {
//            JSONObject temp = new JSONObject(stateObj.toString());
//            if (temp.has("State"))
//                if (mainObj.has(temp.getString("State"))) {
//                    JSONArray cityTempArray = mainObj.getJSONArray(temp.getString("State"));
//                    cityTempArray.put(temp.getString("Name of City"));
//                    mainObj.put(temp.getString("State"), cityTempArray);
//                } else {
//                    JSONArray cityTempArray = new JSONArray();
//                    cityTempArray.put(temp.getString("Name of City"));
//                    mainObj.put(temp.getString("State"), cityTempArray);
//                }
//        });
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        HttpRequestInitializer requestInitializer = getCredentials(HTTP_TRANSPORT);
        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        String secret = Util.generateSecretKey();
        System.out.println("[Google] " + getGoogleAuthenticatorBarCode(secret));
//        java.io.File filePath = new java.io.File("C:\\Users\\VX979NS\\Downloads\\photo-1503023345310-bd7c1de61c7d.jpg");
//        FileContent mediaContent = new FileContent("image/jpeg", filePath);
//        File fileMetadata = new File();
//        fileMetadata.setName("photo1.jpg");
//        fileMetadata.setParents(Collections.singletonList(DirectoryId));
//        File gfile = service.files().create(fileMetadata, mediaContent)
//                .setFields("id, parents")
//                .execute();

//        System.out.println("File ID: " + gfile.getId());
        // Print the names and IDs for up to 10 files.

        FileList result = service.files().list()
                .setPageSize(10)
                .setFields("nextPageToken, files(parents,name, id, webViewLink)")
                .execute();
        List<File> files = result.getFiles();
        if (files == null || files.isEmpty()) {
            System.out.println("No files found.");
        } else {
            System.out.println("Files:");
            for (File file : files) {
//                service.files().delete(file.getId()).execute();
                System.out.printf("%s [%s] (%s) (%s)\n", file.getParents(), file.getName(), file.getId(), file.getWebViewLink());
            }
        }
    }

}
