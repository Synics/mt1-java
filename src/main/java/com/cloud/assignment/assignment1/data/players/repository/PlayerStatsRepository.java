package com.cloud.assignment.assignment1.data.players.repository;

import com.cloud.assignment.assignment1.data.players.entity.PlayerStatsEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerStatsRepository extends JpaRepository<PlayerStatsEntity, Integer> {
    @Query("SELECT o FROM QBStatsEntity o WHERE o.playerId = ?1")
    List<PlayerStatsEntity> getPlayerStats(Integer playerId, Sort sort);
}
