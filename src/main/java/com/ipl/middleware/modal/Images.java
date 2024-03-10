package com.ipl.middleware.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Images {
    private String name;
    private String imageId;
    private String imageViewLink;
    private String imageShareLink;
}
