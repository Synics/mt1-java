package com.cloud.assignment.assignment1.data.players.repository;

import com.cloud.assignment.assignment1.data.players.entity.PlayerWeeklyStatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface PlayerWeeklyStatsRepository extends JpaRepository<PlayerWeeklyStatsEntity, Integer> {
    @Query("SELECT o FROM PlayerWeeklyStatsEntity o WHERE o.playerId = ?1")
    List<PlayerWeeklyStatsEntity> getPlayerStats(Integer playerId, Sort sort);
}
