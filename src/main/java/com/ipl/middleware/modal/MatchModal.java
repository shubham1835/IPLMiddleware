package com.ipl.middleware.modal;

import lombok.Data;
import org.javers.core.metamodel.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("ipl_matches")
public class MatchModal {
    @Id
    private String id;
    private String match;
    private String homeTeam;
    private String opponentTeam;
    private String date;
    private String matchId;
    private String lastBidTime;
}
