package com.cloud.assignment.assignment1.service.users.controllers;


import com.cloud.assignment.assignment1.data.users.entity.UserTeamEntity;
import com.cloud.assignment.assignment1.service.base.BaseController;
import com.cloud.assignment.assignment1.service.users.models.UserTeamModel;
import com.cloud.assignment.assignment1.service.users.services.UserTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user/team")
public class UserTeamController extends BaseController<UserTeamModel, UserTeamEntity, Integer> {
    UserTeamService service;

    @Autowired
    UserTeamController(UserTeamService service){
        super(service);
        this.service = service;
    }

}

