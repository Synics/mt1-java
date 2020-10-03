package com.cloud.assignment.assignment1.data.players.repository;

import com.cloud.assignment.assignment1.data.players.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {
}
