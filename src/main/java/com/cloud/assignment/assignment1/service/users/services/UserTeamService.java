package com.cloud.assignment.assignment1.service.users.services;

import com.cloud.assignment.assignment1.data.users.entity.UserTeamEntity;
import com.cloud.assignment.assignment1.data.users.repository.UserTeamRepository;
import com.cloud.assignment.assignment1.service.base.BaseService;
import com.cloud.assignment.assignment1.service.users.models.UserTeamModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserTeamService extends BaseService<UserTeamModel, UserTeamEntity, Integer> {
    private UserTeamRepository repository;

    @Autowired
    UserTeamService(UserTeamRepository repository) {
        super(UserTeamModel.class, UserTeamEntity.class, repository);
        this.repository = repository;
    }
}
