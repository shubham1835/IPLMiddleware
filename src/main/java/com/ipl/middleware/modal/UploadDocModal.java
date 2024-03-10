package com.ipl.middleware.modal;

import lombok.Data;
import org.javers.core.metamodel.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("doc_master")
public class UploadDocModal {
    @Id
    private String id;
    private String gst;
    private List<String> documentName;
    private String entityType;
    private String path;
}
