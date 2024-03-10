package com.ipl.middleware.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class OrderVariantDTO {
    @NotNull(message = "storeId should not be null")
    @NotEmpty(message = "storeId should not be empty")
    private String storeId;
    @NotNull(message = "category should not be null")
    @NotEmpty(message = "category should not be empty")
    private String category;
    @NotNull(message = "productName should not be null")
    @NotEmpty(message = "productName should not be empty")
    private String productName;
    @NotNull(message = "productCode should not be null")
    @NotEmpty(message = "productCode should not be empty")
    private String productCode;
    @NotNull(message = "sku should not be null")
    @NotEmpty(message = "sku should not be empty")
    private String sku;
    @NotNull(message = "subsku should not be null")
    @NotEmpty(message = "subsku should not be empty")
    private String subsku;
    @NotNull(message = "variant should not be null")
    @NotEmpty(message = "variant should not be empty")
    private String variant;
    @NotNull(message = "variantValue should not be null")
    @NotEmpty(message = "variantValue should not be empty")
    private String variantValue;
    @NotNull(message = "unit should not be null")
    @NotEmpty(message = "unit should not be empty")
    private long unit;
    @NotNull(message = "price should not be null")
    @NotEmpty(message = "price should not be empty")
    private double price;
    @NotNull(message = "list price should not be null")
    @NotEmpty(message = "list price should not be empty")
    private double listPrice;
    @NotNull(message = "sellingPrice should not be null")
    @NotEmpty(message = "sellingPrice should not be empty")
    private double sellingPrice;
    private double discount;
}
