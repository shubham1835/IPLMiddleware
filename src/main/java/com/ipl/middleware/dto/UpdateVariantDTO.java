package com.ipl.middleware.dto;

import lombok.Data;


@Data
public class UpdateVariantDTO {
    private String variant;
    private SingleVariantDTO allVariants;
}
