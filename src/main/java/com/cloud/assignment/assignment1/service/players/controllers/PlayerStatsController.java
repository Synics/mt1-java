package com.cloud.assignment.assignment1.service.players.controllers;

import com.cloud.assignment.assignment1.data.players.entity.PlayerWeeklyStatsEntity;
import com.cloud.assignment.assignment1.service.base.BaseController;
import com.cloud.assignment.assignment1.service.players.models.PlayerWeeklyStatsModel;
import com.cloud.assignment.assignment1.service.players.services.PlayerStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/player/stats")
public class PlayerStatsController extends BaseController<PlayerWeeklyStatsModel, PlayerWeeklyStatsEntity, Integer> {
    PlayerStatsService service;

    @Autowired
    PlayerStatsController(PlayerStatsService service){
        super(service);
        this.service = service;
    }

}

