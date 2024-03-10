package com.ipl.middleware.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryServiceDTO {

    private String serviceName;
    private String productDriveId;
    private String description;
    private String productCode;
    private String sku;
    private long price;
}
