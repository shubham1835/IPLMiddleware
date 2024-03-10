package com.ipl.middleware.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SingleVariantDTO {
    @NotNull(message = "variantValue should not be null")
    @NotEmpty(message = "variantValue should not be empty")
    private String variantValue;
    private String newVariantValue;
    @NotNull(message = "subsku should not be null")
    @NotEmpty(message = "subsku should not be empty")
    private String subsku;
    @NotNull(message = "unit should not be null")
    @NotEmpty(message = "unit should not be empty")
    private String unit;
    @NotNull(message = "price should not be null")
    @NotEmpty(message = "price should not be empty")
    private String price;
    private List<Images> images;
}
