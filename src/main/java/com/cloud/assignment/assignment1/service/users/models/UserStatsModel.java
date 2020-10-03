package com.cloud.assignment.assignment1.service.users.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

public class UserStatsModel {
    @Getter @Setter
    private Integer id;

    @Column
    @Getter @Setter
    private Integer userId;

    @Column
    @Getter @Setter
    private Integer week;

    @Column
    @Getter @Setter
    private Integer score;
}
