package com.cloud.assignment.assignment1.service.players.models;

import lombok.Getter;
import lombok.Setter;

public class PlayerStatsModel {
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private Integer playerId;

    @Getter @Setter
    private Integer year;

    @Getter @Setter
    private String team;

    @Getter @Setter
    private String position;

    @Getter @Setter
    private Integer games;

    @Getter @Setter
    private Integer gamesStarted;

    @Getter @Setter
    private Integer rushing;

    @Getter @Setter
    private Integer rushingYards;

    @Getter @Setter
    private Integer touchdowns;

    @Getter @Setter
    private Integer receptions;

    @Getter @Setter
    private Integer receptionYards;
}
