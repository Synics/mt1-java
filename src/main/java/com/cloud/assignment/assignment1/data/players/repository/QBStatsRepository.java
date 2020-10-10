package com.cloud.assignment.assignment1.data.players.repository;

import com.cloud.assignment.assignment1.data.players.entity.QBStatsEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QBStatsRepository extends JpaRepository<QBStatsEntity, Integer> {
    @Query("SELECT o FROM QBStatsEntity o WHERE o.playerId = ?1")
    List<QBStatsEntity> getPlayerStats(Integer playerId, Sort sort);
}
