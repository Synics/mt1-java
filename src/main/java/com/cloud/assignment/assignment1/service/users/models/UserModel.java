package com.cloud.assignment.assignment1.service.users.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

public class UserModel {
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private Set<UserStatsModel> userStats;

    @Getter @Setter
    private UserTeamModel userTeam;
}
