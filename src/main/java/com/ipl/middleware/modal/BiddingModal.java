package com.ipl.middleware.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.javers.core.metamodel.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("bid_master")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BiddingModal {
    @Id
    private String id;
    private String bidTime;
    private String user;
    private String bidAmount;
    private String matchId;
    private String bidTeam;
}
