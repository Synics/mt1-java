package com.cloud.assignment.assignment1.service.players.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class PlayerModel {
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    @Getter @Setter
    private String fieldPosition;

    @Getter @Setter
    private String team;

    @Getter @Setter
    private List<PlayerStatsModel> stats;
}
