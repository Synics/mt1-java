package com.cloud.assignment.assignment1.service.players.models;

import lombok.Getter;
import lombok.Setter;


public class PlayerStatsModel {
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private Integer playerId;

    @Getter @Setter
    private Integer week;

    @Getter @Setter
    private Integer score;
}
