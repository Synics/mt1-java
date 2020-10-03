package com.cloud.assignment.assignment1.service.players.services;

import com.cloud.assignment.assignment1.data.players.entity.PlayerStatsEntity;
import com.cloud.assignment.assignment1.data.players.repository.PlayerStatsRepository;
import com.cloud.assignment.assignment1.service.base.BaseService;
import com.cloud.assignment.assignment1.service.players.models.PlayerStatsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerStatsService extends BaseService<PlayerStatsModel, PlayerStatsEntity, Integer> {
    private PlayerStatsRepository repository;

    @Autowired
    PlayerStatsService(PlayerStatsRepository repository) {
        super(PlayerStatsModel.class, PlayerStatsEntity.class, repository);
        this.repository = repository;
    }

    public List<PlayerStatsModel> getPlayerStats(Integer playerId) {
        List<PlayerStatsModel> playerStatsModels = new ArrayList<>();
        for (PlayerStatsEntity playerStatsEntity : this.repository.getPlayerStats(playerId, Sort.by("week"))) {
            playerStatsModels.add(this.getModelMapper().map(playerStatsEntity, PlayerStatsModel.class));
        }
        return playerStatsModels;
    }
}
