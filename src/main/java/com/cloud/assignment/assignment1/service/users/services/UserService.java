package com.cloud.assignment.assignment1.service.users.services;

import com.cloud.assignment.assignment1.data.users.entity.UserEntity;
import com.cloud.assignment.assignment1.data.users.repository.UserRepository;
import com.cloud.assignment.assignment1.service.base.BaseService;
import com.cloud.assignment.assignment1.service.users.models.UserModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends BaseService<UserModel, UserEntity, Integer> {
    private UserRepository repository;
    private ModelMapper skipUserTeamStatsMapper;

    @Autowired
    UserService(UserRepository repository) {
        super(UserModel.class, UserEntity.class, repository);
        this.repository = repository;

        skipUserTeamStatsMapper = new ModelMapper();
        skipUserTeamStatsMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        skipUserTeamStatsMapper.addMappings(skipUserTeamUserStatsMap);
    }

    public List<UserModel> findByUserName(String userName) {
        List<UserModel> user = new ArrayList<>();

        for (UserEntity userEntity : this.repository.findByUsername(userName, Sort.by("firstName"))) {
            user.add(skipUserTeamStatsMapper.map(userEntity, UserModel.class));
        }

        return user;
    }

    @Override
    public List<UserModel> getAll() {
        List<UserModel> models = new ArrayList<>();
        for(UserEntity entity : repository.findAll()) {
            models.add(skipUserTeamStatsMapper.map(entity, UserModel.class));
        }

        return models;
    }

    PropertyMap<UserEntity, UserModel> skipUserTeamUserStatsMap = new PropertyMap<UserEntity, UserModel>() {
        protected void configure() {
            skip(destination.getUserTeam());
            skip(destination.getUserStats());
        }
    };

    PropertyMap<UserEntity, UserModel> skipUserStatsPlayerStatsMap = new PropertyMap<UserEntity, UserModel>() {
        protected void configure() {
            skip(destination.getUserTeam().getQuarterback().getStats());
            skip(destination.getUserTeam().getQuarterback().getRushRecStats());
            skip(destination.getUserTeam().getQuarterback().getPassingStats());

            skip(destination.getUserTeam().getRunningBack1().getStats());
            skip(destination.getUserTeam().getRunningBack1().getRushRecStats());
            skip(destination.getUserTeam().getRunningBack1().getPassingStats());

            skip(destination.getUserTeam().getRunningBack2().getStats());
            skip(destination.getUserTeam().getRunningBack2().getRushRecStats());
            skip(destination.getUserTeam().getRunningBack2().getPassingStats());

            skip(destination.getUserTeam().getWideReceiver1().getStats());
            skip(destination.getUserTeam().getWideReceiver1().getRushRecStats());
            skip(destination.getUserTeam().getWideReceiver1().getPassingStats());

            skip(destination.getUserTeam().getWideReceiver2().getStats());
            skip(destination.getUserTeam().getWideReceiver2().getRushRecStats());
            skip(destination.getUserTeam().getWideReceiver2().getPassingStats());

            skip(destination.getUserTeam().getTightEnd().getStats());
            skip(destination.getUserTeam().getTightEnd().getRushRecStats());
            skip(destination.getUserTeam().getTightEnd().getPassingStats());
        }
    };

    @Override
    public UserModel getById(Integer id) {
        UserEntity entity = repository.findById(id).get();
        ModelMapper customModelMapper = new ModelMapper();
        customModelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        customModelMapper.addMappings(skipUserStatsPlayerStatsMap);

        return customModelMapper.map(entity, UserModel.class);
    }
}
