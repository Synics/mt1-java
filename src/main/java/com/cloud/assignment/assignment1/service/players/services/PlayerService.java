package com.cloud.assignment.assignment1.service.players.services;

import com.cloud.assignment.assignment1.data.players.entity.PlayerEntity;
import com.cloud.assignment.assignment1.data.players.repository.PlayerRepository;
import com.cloud.assignment.assignment1.service.base.BaseService;
import com.cloud.assignment.assignment1.service.players.models.PlayerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService extends BaseService<PlayerModel, PlayerEntity, Integer> {
    private PlayerRepository repository;

    @Autowired
    PlayerService(PlayerRepository repository) {
        super(PlayerModel.class, PlayerEntity.class, repository);
        this.repository = repository;
    }
}
