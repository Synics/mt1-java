package com.cloud.assignment.assignment1.service.users.services;

import com.cloud.assignment.assignment1.data.users.entity.UserEntity;
import com.cloud.assignment.assignment1.data.users.repository.UserRepository;
import com.cloud.assignment.assignment1.service.base.BaseService;
import com.cloud.assignment.assignment1.service.users.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends BaseService<UserModel, UserEntity, Integer> {
    private UserRepository repository;

    @Autowired
    UserService(UserRepository repository) {
        super(UserModel.class, UserEntity.class, repository);
        this.repository = repository;
    }

    public List<UserModel> findByUserName(String userName) {
        List<UserModel> user = new ArrayList<>();

        for (UserEntity userEntity : this.repository.findByUsername(userName, Sort.by("firstName"))) {
            user.add(this.getModelMapper().map(userEntity, UserModel.class));
        }

        return user;
    }
}
