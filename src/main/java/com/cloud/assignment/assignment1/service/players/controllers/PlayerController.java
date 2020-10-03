package com.cloud.assignment.assignment1.service.players.controllers;

import com.cloud.assignment.assignment1.data.players.entity.PlayerEntity;
import com.cloud.assignment.assignment1.service.base.BaseController;
import com.cloud.assignment.assignment1.service.players.models.PlayerModel;
import com.cloud.assignment.assignment1.service.players.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/player")
public class PlayerController extends BaseController<PlayerModel, PlayerEntity, Integer> {
    PlayerService service;

    @Autowired
    PlayerController(PlayerService service){
        super(service);
        this.service = service;
    }

}

