package com.ipl.middleware.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ipl.middleware.dto.ActiveDays;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document("slot_master")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SlotModal {

    @Id
    private String id;
    private String closingTime;
    private String openingTime;
    private List<ActiveDays> activeDays;
}
