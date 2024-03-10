package com.ipl.middleware.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleVariant {
    private String variantValue;
    private String variantValueDriveId;
    private String subsku;
    private String unit;
    private String price;
    private List<Images> images;
}
