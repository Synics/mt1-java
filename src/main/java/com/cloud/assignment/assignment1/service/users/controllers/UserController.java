package com.cloud.assignment.assignment1.service.users.controllers;

import com.cloud.assignment.assignment1.data.users.entity.UserEntity;
import com.cloud.assignment.assignment1.service.base.BaseController;
import com.cloud.assignment.assignment1.service.players.models.PlayerStatsModel;
import com.cloud.assignment.assignment1.service.players.services.PlayerStatsService;
import com.cloud.assignment.assignment1.service.users.models.UserStatsModel;
import com.cloud.assignment.assignment1.service.users.services.UserService;
import com.cloud.assignment.assignment1.service.users.models.UserModel;
import com.cloud.assignment.assignment1.service.users.services.UserStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController extends BaseController<UserModel, UserEntity, Integer> {
    UserService service;
    PlayerStatsService playerStatsService;
    UserStatsService userStatsService;

    @Autowired
    UserController(UserService service, PlayerStatsService playerStatsService, UserStatsService userStatsService){
        super(service);
        this.service = service;
        this.playerStatsService = playerStatsService;
        this.userStatsService = userStatsService;
    }

    @CrossOrigin
    @PostMapping(value = {"/create"})
    @ResponseBody
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel userModel) {
        return new ResponseEntity<>(this.service.create(userModel), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = {"/validate/{username}/{password}"})
    @ResponseBody
    public ResponseEntity<UserModel> validate(@PathVariable final String username, @PathVariable final String password) {
        UserModel userData = new UserModel();

        for (UserModel user : this.service.findByUserName(username)) {
            if (user.getPassword().equals(password)) {
                userData = user;
            }
        }
        return new ResponseEntity<>(userData, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/isTaken/{username}")
    @ResponseBody
    public ResponseEntity<Boolean> isTaken(@PathVariable final String username) {
        Boolean isTaken = false;

        if (this.service.findByUserName(username).size() > 0) {
            isTaken = true;
        }

        return new ResponseEntity<>(isTaken, HttpStatus.OK);
    }

    @Override
    @CrossOrigin
    @PutMapping
    @ResponseBody
    public ResponseEntity<UserModel> update(@RequestBody UserModel mdl) {
        UserModel userModel = this.service.update(mdl);

        if(userModel.getUserTeam() != null && (userModel.getUserStats() == null || userModel.getUserStats().isEmpty())) {
            List<List<PlayerStatsModel>> teamStats = new ArrayList<>();
            List<UserStatsModel> userWeeklyStats = new ArrayList<>();

            teamStats.add(this.playerStatsService.getPlayerStats(userModel.getUserTeam().getQuarterback().getId()));
            teamStats.add(this.playerStatsService.getPlayerStats(userModel.getUserTeam().getRunningBack1().getId()));
            teamStats.add(this.playerStatsService.getPlayerStats(userModel.getUserTeam().getRunningBack2().getId()));
            teamStats.add(this.playerStatsService.getPlayerStats(userModel.getUserTeam().getWideReceiver1().getId()));
            teamStats.add(this.playerStatsService.getPlayerStats(userModel.getUserTeam().getWideReceiver2().getId()));
            teamStats.add(this.playerStatsService.getPlayerStats(userModel.getUserTeam().getTightEnd().getId()));

            for(int week = 1; week <= 17; week++) {
                UserStatsModel userStatsModel = new UserStatsModel();
                userStatsModel.setUserId(userModel.getId());
                userStatsModel.setWeek(week);
                userStatsModel.setScore(0);

                for(List<PlayerStatsModel> playerStatsList : teamStats) {
                    userStatsModel.setScore(userStatsModel.getScore() + playerStatsList.get(week - 1).getScore());
                }
                userWeeklyStats.add(userStatsModel);
            }

            for (UserStatsModel userStatsModel : userWeeklyStats) {
                if (userStatsModel.getWeek() != 1) {
                    userStatsModel.setScore(userStatsModel.getScore() + userWeeklyStats.get(userStatsModel.getWeek() - 2).getScore());
                }
                this.userStatsService.create(userStatsModel);
            }
        }
        return new ResponseEntity<>(this.service.update(mdl), HttpStatus.OK);
    }
}

