package com.ipl.middleware.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class InvoiceDTO {
    private String gst;
    private String createdBy;
    private String state;
    private String fromdate;
    private String subTotal;
    private String sgstTotal;
    private String cgstTotal;
    private String gstTotal;
    private String tillDate;
    private String transportName;
    private String deliveryLocation;
    private Map customerDetails;
    private List<Map> items;
}
