package com.ipl.middleware.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class DocUploadDTO {

//    @NotNull
//    @NotEmpty
//    @DbLookupValidateTypeFields(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}")
//    private String panNo;
    @NotNull
    @NotEmpty
    private String gst;
    @NotNull
    @NotEmpty
    private String documentName;
    @NotNull(message = "entityType cannot be null")
    @NotEmpty
    private String entityType;
    @NotNull
    private MultipartFile file;
}
