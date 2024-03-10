package com.ipl.middleware.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class InventoryDTO {
    @NotNull(message = "storeId should not be null")
    @NotEmpty(message = "storeId should not be empty")
    private String storeId;
    @NotNull(message = "category should not be null")
    @NotEmpty(message = "category should not be empty")
    private String category;
    @NotNull(message = "productName should not be null")
    @NotEmpty(message = "productName should not be empty")
    private String productName;
    private String description;
    @NotNull(message = "productCode should not be null")
    @NotEmpty(message = "productCode should not be empty")
    private String productCode;
    @NotNull(message = "sku should not be null")
    @NotEmpty(message = "sku should not be empty")
    private String sku;
    @NotNull(message = "variants should not be null")
    @NotEmpty(message = "variants should not be empty")
    private List<VariantDTO> variants;
}
