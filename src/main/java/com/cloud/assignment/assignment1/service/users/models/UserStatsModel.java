package com.cloud.assignment.assignment1.service.users.models;

import lombok.Getter;
import lombok.Setter;

public class UserStatsModel {
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private Integer userId;

    @Getter @Setter
    private Integer week;

    @Getter @Setter
    private Integer score;

    @Getter @Setter
    private Integer totalScore;
}
