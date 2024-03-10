package com.ipl.middleware.modal;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("txn_master")
public class TxnMaster {
    @Id
    private String id;
    private long srcAcct;
    private long destAcct;
    private String totalBill;
    private String discountAmount;
    private String billingAmount;
    private String promoApplied;
    private String txnType;
    private String txnDate;
    private String openingBalance;
    private String closingBalance;
    private String txnId;
    private String authCode;
    private String orderId;
    private String txnStatus;
    private String mode;
    private String transactionFee;
    private String amount;
    private String productinfo;
    private String firstname;
    private String email;
    private String paymentSource;
    private String bankRefNo;
    private String crdrFlag;
}
