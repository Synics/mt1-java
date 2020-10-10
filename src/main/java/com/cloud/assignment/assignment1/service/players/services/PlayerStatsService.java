package com.cloud.assignment.assignment1.service.players.services;

import com.cloud.assignment.assignment1.data.players.entity.PlayerWeeklyStatsEntity;
import com.cloud.assignment.assignment1.data.players.repository.PlayerWeeklyStatsRepository;
import com.cloud.assignment.assignment1.service.base.BaseService;
import com.cloud.assignment.assignment1.service.players.models.PlayerWeeklyStatsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerStatsService extends BaseService<PlayerWeeklyStatsModel, PlayerWeeklyStatsEntity, Integer> {
    private PlayerWeeklyStatsRepository repository;

    @Autowired
    PlayerStatsService(PlayerWeeklyStatsRepository repository) {
        super(PlayerWeeklyStatsModel.class, PlayerWeeklyStatsEntity.class, repository);
        this.repository = repository;
    }

    public List<PlayerWeeklyStatsModel> getPlayerStats(Integer playerId) {
        List<PlayerWeeklyStatsModel> playerStatsModels = new ArrayList<>();
        for (PlayerWeeklyStatsEntity playerStatsEntity : this.repository.getPlayerStats(playerId, Sort.by("week"))) {
            playerStatsModels.add(this.getModelMapper().map(playerStatsEntity, PlayerWeeklyStatsModel.class));
        }
        return playerStatsModels;
    }
}
