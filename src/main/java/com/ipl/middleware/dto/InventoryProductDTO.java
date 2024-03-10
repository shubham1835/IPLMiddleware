package com.ipl.middleware.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ipl.middleware.modal.VariantModal;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryProductDTO {

    private String productName;
    private String productDriveId;
    private String description;
    private String productCode;
    private String sku;
    private List<VariantModal> variants;
}
