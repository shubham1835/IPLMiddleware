package com.ipl.middleware.modal;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class OrderVariantModal {
    private String storeId;
    private String category;
    private String productName;
    private String productCode;
    private String sku;
    private String subsku;
    private String variant;
    private String variantValue;
    private long unit;
    private double price;
    private double listPrice;
    private double sellingPrice;
    private double discount;
}
