package com.ipl.middleware.dto;

import lombok.Data;

import java.util.List;

@Data
public class LoginDTO {
    private String id;
    private String userName;
    private String businessName;
    private boolean kyc;
    private String merchantId;
    private String entityType;
    private String businessCategory;
    private String closingTime;
    private String openingTime;
    private List<ActiveDays> activeDays;
    private String businessType;
    private String mobileNo;
    private String emailId;
    private String billingAddress;
    private String city;
    private String pincode;
    private String gst;
    private String role;
    private String pan;
    private int entityFlag;
}
