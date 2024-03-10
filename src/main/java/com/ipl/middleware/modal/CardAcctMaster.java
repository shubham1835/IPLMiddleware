package com.ipl.middleware.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document("card_account_master")
@AllArgsConstructor
public class CardAcctMaster {
    @Id
    private String id;
    private String storeId;
    private long cardNo;
    private double balance;
    private String cardType;
    private String cardLimitCode;
    private String acctDate;
    private String expDate;
    private String cardStatus;
    private long sequence;
}

