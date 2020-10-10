package com.cloud.assignment.assignment1.service.players.models;

import lombok.Getter;
import lombok.Setter;

public class QBStatsModel {
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
    private Integer completions;

    @Getter @Setter
    private Integer attempts;

    @Getter @Setter
    private float completionPercentage;

    @Getter @Setter
    private Integer passingYards;

    @Getter @Setter
    private Integer interceptions;

    @Getter @Setter
    private Integer touchdowns;

    @Getter @Setter
    private float rating;
}
