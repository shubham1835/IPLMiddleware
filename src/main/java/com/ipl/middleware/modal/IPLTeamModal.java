package com.ipl.middleware.modal;

import lombok.Data;
import org.javers.core.metamodel.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("ipl_teams")
public class IPLTeamModal {
    @Id
    private String id;
    private String teamName;
    private String teamCaptain;
    private List<String> playerList;
}
