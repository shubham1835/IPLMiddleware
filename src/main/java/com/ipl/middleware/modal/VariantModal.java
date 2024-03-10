package com.ipl.middleware.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VariantModal {
    private String variant;
    private String variantDriveId;
    private List<SingleVariant> allVariants;
}

