package com.ipl.middleware.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document("merchant_master")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantModal {
    @Id
    private String id;
    private String userName;
    private String password;
    private String merchantId;
    private String businessName;
    private String businessCategory;
    private String businessType;
    private String mobileNo;
    private String emailId;
    private String businessAddress;
    private String state;
    private String city;
    private String pincode;
    private String date;
    private String pan;
    private String gst;
    private List<Map> document;
    private String initials;
    private String entityType;
    private boolean kyc;
}
