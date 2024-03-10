package com.ipl.middleware.utils;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.drive.model.Permission;
import com.ipl.middleware.Test;
import de.taimos.totp.TOTP;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import org.javers.common.collections.Pair;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Collections;
import java.util.Optional;

@Slf4j
public class Util {
    private static final String SERVICE_ACCOUNT_KEY = "/drive-project-323207-cd2f4d5c7202.json";
    private static final String APPLICATION_NAME = "Google Drive API project";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    public static Drive getService() throws IOException, GeneralSecurityException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        // Load client secrets.
        InputStream keyInputStream = Test.class.getResourceAsStream(SERVICE_ACCOUNT_KEY);
        if (keyInputStream == null) {
            throw new FileNotFoundException("Resource not found: " + SERVICE_ACCOUNT_KEY);
        }

        GoogleCredential credential = GoogleCredential.fromStream(keyInputStream)
                .createScoped(Collections.singleton(DriveScopes.DRIVE));

        return new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static String generateSecretKey() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        Base32 base32 = new Base32();
        return base32.encodeToString(bytes);
    }

    public static String getTOTPCode(String secretKey) {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey);
        String hexKey = Hex.encodeHexString(bytes);
        return TOTP.getOTP(hexKey);
    }

    public static String getGoogleAuthenticatorBarCode(String secretKey, String account, String issuer) {
        try {
            return "otpauth://totp/"
                    + URLEncoder.encode(issuer + ":" + account, "UTF-8").replace("+", "%20")
                    + "?secret=" + URLEncoder.encode(secretKey, "UTF-8").replace("+", "%20")
                    + "&issuer=" + URLEncoder.encode(issuer, "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    @SneakyThrows
    public static Pair<Drive, File> getOrCreateFile(String folderName) {
        Drive drive = Util.getService();
        Drive.Files.List request = drive.files().list().setQ(
                "mimeType='" + Constants.FOLDER_MIME_TYPE + "' and trashed=false");
        FileList files = request.execute();

        Optional<File> driveFolder = files.getFiles().parallelStream()
                .filter(driveFile -> driveFile.getName().equalsIgnoreCase(folderName))
                .peek(name -> log.info("{%s}", name.getName()))
                .findFirst();
        return new Pair<>(drive, driveFolder.orElseGet(() -> createFolder(drive, null, folderName)));
    }

    @SneakyThrows
    public static File getFile(String fileId) {
        return Util.getService().files().get(fileId).execute();
    }

    public static void createPublicPermission(String googleFileId) throws IOException, GeneralSecurityException {
        // All values: user - group - domain - anyone
        String permissionType = "anyone";
        // All values: organizer - owner - writer - commenter - reader
        String permissionRole = "reader";

        Permission newPermission = new Permission();
        newPermission.setType(permissionType);
        newPermission.setRole(permissionRole);

        Drive driveService = Util.getService();
        driveService.permissions().create(googleFileId, newPermission).execute();
    }

    @SneakyThrows
    public static File createFolder(Drive drive, String parentFolder, String folderName) {
        File folderMetadata = new File();
        folderMetadata.setParents(Collections.singletonList(parentFolder == null ? Constants.DIRECTORY_ID : parentFolder));
        folderMetadata.setName(folderName);
        folderMetadata.setMimeType(Constants.FOLDER_MIME_TYPE);

        return drive.files().create(folderMetadata)
                .setFields("id")
                .execute();

    }

    public static void deleteFile(String fileId) throws GeneralSecurityException, IOException {
        getService().files().delete(fileId).execute();
    }

    public static BufferedImage decodeToImage(String imageString) {
        BufferedImage image = null;
        byte[] decodedBytes = Base64.getDecoder().decode(imageString);
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
}
