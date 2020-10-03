package com.cloud.assignment.assignment1.service.users.controllers;

import com.cloud.assignment.assignment1.data.users.entity.UserStatsEntity;
import com.cloud.assignment.assignment1.service.base.BaseController;
import com.cloud.assignment.assignment1.service.users.models.UserStatsModel;
import com.cloud.assignment.assignment1.service.users.services.UserStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user/stats")
public class UserStatsController extends BaseController<UserStatsModel, UserStatsEntity, Integer> {
    UserStatsService service;

    @Autowired
    UserStatsController(UserStatsService service){
        super(service);
        this.service = service;
    }

    @CrossOrigin
    @GetMapping(value = {"/{userId}"})
    @ResponseBody
    public ResponseEntity<UserStatsModel> getUserStats(@PathVariable final Integer userId) {
        UserStatsModel userStats = new UserStatsModel();

        for (UserStatsModel userStatsModel : this.service.findByUserId(userId)) {
            if (userStatsModel.getId() == userId) {
                userStats = userStatsModel;
            }
        }
        return new ResponseEntity<>(userStats, HttpStatus.OK);
    }
}

