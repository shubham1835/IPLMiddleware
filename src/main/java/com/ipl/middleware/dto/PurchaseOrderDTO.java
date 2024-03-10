package com.ipl.middleware.dto;

import lombok.Data;
import org.javers.core.metamodel.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
public class PurchaseOrderDTO {
    private String createdBy;
    private Map customerDetails;
    private String deliveryDate;
    private String paymentTerms;
    private String requestedBy;
    private String department;
    private String subTotal;
    private String sgstTotal;
    private String cgstTotal;
    private String gstTotal;
    private List<Map> items;
    private String shippingCharge;
    private String otherCharges;
    private String comments;
}
