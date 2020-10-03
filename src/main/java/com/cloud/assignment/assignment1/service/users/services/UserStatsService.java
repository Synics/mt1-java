package com.cloud.assignment.assignment1.service.users.services;

import com.cloud.assignment.assignment1.data.users.entity.UserStatsEntity;
import com.cloud.assignment.assignment1.data.users.repository.UserStatsRepository;
import com.cloud.assignment.assignment1.service.base.BaseService;
import com.cloud.assignment.assignment1.service.users.models.UserStatsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserStatsService extends BaseService<UserStatsModel, UserStatsEntity, Integer> {
    private UserStatsRepository repository;

    @Autowired
    UserStatsService(UserStatsRepository repository) {
        super(UserStatsModel.class, UserStatsEntity.class, repository);
        this.repository = repository;
    }

    public List<UserStatsModel> findByUserId(Integer userId) {
        List<UserStatsModel> user = new ArrayList<>();

        for (UserStatsEntity userEntity : this.repository.findByUserId(userId, Sort.by("firstName"))) {
            user.add(this.getModelMapper().map(userEntity, UserStatsModel.class));
        }

        return user;
    }
}
