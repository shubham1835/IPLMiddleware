package com.ipl.middleware.modal;

import lombok.Data;
import org.javers.core.metamodel.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document("invoice_master")
public class InvoiceModal {
    @Id
    private String id;
    private String gst;
    private String tillDate;
    private String transportName;
    private String deliveryLocation;
    private Map customerDetails;
    private String createdBy;
    private List<Map> items;
    private String sequence;
    private String invoiceNumber;
    private String sysDate;
    private String state;
    private String fromdate;
    private String subTotal;
    private String sgstTotal;
    private String cgstTotal;
    private String gstTotal;
}
