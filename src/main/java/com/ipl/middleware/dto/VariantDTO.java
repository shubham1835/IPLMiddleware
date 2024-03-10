package com.ipl.middleware.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class VariantDTO {
    @NotNull(message = "variant should not be null")
    @NotEmpty(message = "variant should not be empty")
    private String variant;
    @NotNull(message = "allVariants should not be null")
    @NotEmpty(message = "allVariants should not be empty")
    private List<SingleVariantDTO> allVariants;
}

