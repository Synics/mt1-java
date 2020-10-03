package com.cloud.assignment.assignment1.service.users.controllers;

import com.cloud.assignment.assignment1.data.users.entity.UserEntity;
import com.cloud.assignment.assignment1.service.base.BaseController;
import com.cloud.assignment.assignment1.service.users.services.UserService;
import com.cloud.assignment.assignment1.service.users.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController extends BaseController<UserModel, UserEntity, Integer> {
    UserService service;

    @Autowired
    UserController(UserService service){
        super(service);
        this.service = service;
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
}

