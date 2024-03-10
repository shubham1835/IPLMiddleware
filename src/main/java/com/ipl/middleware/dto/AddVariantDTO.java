package com.ipl.middleware.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AddVariantDTO {
    @NotNull(message = "category should not be null")
    @NotEmpty(message = "category should not be empty")
    private String category;
    @NotNull(message = "productName should not be null")
    @NotEmpty(message = "productName should not be empty")
    private String productName;
    @NotNull(message = "variants should not be null")
    private VariantDTO variants;
}
