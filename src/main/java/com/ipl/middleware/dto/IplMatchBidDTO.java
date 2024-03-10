package com.ipl.middleware.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class IplMatchBidDTO {
    @NotNull(message = "date should not be null")
    @NotEmpty(message = "date should not be empty")
    private String bidTime;
    @NotNull(message = "user should not be null")
    @NotEmpty(message = "user should not be empty")
    private String user;
    @NotNull(message = "bidAmount should not be null")
    @NotEmpty(message = "bidAmount should not be empty")
    private String bidAmount;
    @NotNull(message = "matchId should not be null")
    @NotEmpty(message = "matchId should not be empty")
    private String matchId;
    @NotNull(message = "Team should not be null")
    @NotEmpty(message = "Team should not be empty")
    private String bidTeam;
}
