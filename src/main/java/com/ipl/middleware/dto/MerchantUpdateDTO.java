package com.ipl.middleware.dto;

import com.ipl.middleware.validation.DbLookupValidateTypeFields;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class MerchantUpdateDTO {
    @NotNull(message = "id should not be null")
    @NotEmpty(message = "id should not be empty")
    private String id;
    @NotNull(message = "businessName should not be null")
    @NotEmpty(message = "businessName should not be empty")
    private String businessName;
    @NotNull
    @NotEmpty
    private String businessCategory;

    private String closingTime;
    private String openingTime;
    private List<ActiveDays> activeDays;

    @NotNull
    @NotEmpty
    private String businessType;
    @DbLookupValidateTypeFields(regexp = "[0-9]{10}")
    private String mobileNo;
    @NotNull
    @NotEmpty
    private String emailId;
    @NotNull
    @NotEmpty
    private String businessAddress;
    @NotNull
    @NotEmpty
    private String state;
    @NotNull
    @NotEmpty
    private String city;
    @DbLookupValidateTypeFields(regexp = "[0-9]{6}")
    private String pincode;
    //    @NotNull
//    @NotEmpty
//    @DbLookupValidateTypeFields(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}")
//    private String pan;
    @NotNull(message = "entityType cannot be null")
    @NotEmpty
    private String entityType;
    @NotNull
    @NotEmpty
    private String gst;
}
