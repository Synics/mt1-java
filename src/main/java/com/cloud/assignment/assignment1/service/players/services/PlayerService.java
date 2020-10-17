package com.cloud.assignment.assignment1.service.players.services;

import com.cloud.assignment.assignment1.data.players.entity.PlayerEntity;
import com.cloud.assignment.assignment1.data.players.repository.PlayerRepository;
import com.cloud.assignment.assignment1.service.base.BaseService;
import com.cloud.assignment.assignment1.service.players.models.PlayerModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService extends BaseService<PlayerModel, PlayerEntity, Integer> {
    private PlayerRepository repository;
    private ModelMapper customModelMapper;

    @Autowired
    PlayerService(PlayerRepository repository) {
        super(PlayerModel.class, PlayerEntity.class, repository);
        this.repository = repository;

        customModelMapper = new ModelMapper();
        customModelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        customModelMapper.addMappings(skipPlayerStats);
    }

    @Override
    public List<PlayerModel> getAll() {
        List<PlayerModel> models = new ArrayList<>();

        for(PlayerEntity entity : repository.findAll(Sort.by("fieldPosition"))) {
            models.add(customModelMapper.map(entity, PlayerModel.class));
        }

        return models;
    }

    PropertyMap<PlayerEntity, PlayerModel> skipPlayerStats = new PropertyMap<PlayerEntity, PlayerModel>() {
        protected void configure() {
            skip(destination.getPassingStats());
            skip(destination.getRushRecStats());
            skip(destination.getStats());
        }
    };
}
