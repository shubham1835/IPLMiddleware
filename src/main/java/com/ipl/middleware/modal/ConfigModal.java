package com.ipl.middleware.modal;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("config")
public class ConfigModal {
    @Id
    private String id;
    private String key;
    private List<?> values;
}
