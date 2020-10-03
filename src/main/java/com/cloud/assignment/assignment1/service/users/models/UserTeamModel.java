package com.cloud.assignment.assignment1.service.users.models;

import com.cloud.assignment.assignment1.service.players.models.PlayerModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

public class UserTeamModel {
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private Integer userId;

    @Getter @Setter
    private PlayerModel quarterback;

    @Getter @Setter
    private PlayerModel runningBack1;

    @Getter @Setter
    private PlayerModel runningBack2;

    @Getter @Setter
    private PlayerModel wideReceiver1;

    @Getter @Setter
    private PlayerModel wideReceiver2;

    @Getter @Setter
    private PlayerModel tightEnd;
}
