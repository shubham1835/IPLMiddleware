package com.ipl.middleware.dto;

import lombok.Data;

import java.util.List;

@Data
public class InventorySectionListData {
    private String title;
    private List<InventoryProductDTO> data;
}
