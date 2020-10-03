package com.cloud.assignment.assignment1.data.players.repository;

import com.cloud.assignment.assignment1.data.players.entity.PlayerStatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerStatsRepository extends JpaRepository<PlayerStatsEntity, Integer> {
}
