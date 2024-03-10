package com.ipl.middleware.modal;

import lombok.Data;
import org.javers.core.metamodel.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document("purchase_order_master")
public class POModal {
    @Id
    private String id;
    private Map customerDetails;
    private String createdBy;
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
    private String poNumber;
    private String sysDate;
    private String sequence;
}
