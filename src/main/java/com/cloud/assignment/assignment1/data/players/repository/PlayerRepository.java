package com.cloud.assignment.assignment1.data.players.repository;

import com.cloud.assignment.assignment1.data.players.entity.PlayerEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {
    @EntityGraph(value = "graph.playerEntity.partialFetch", type = EntityGraph.EntityGraphType.LOAD)
    Optional<PlayerEntity> findById(Integer var1);

    @EntityGraph(value = "graph.playerEntity.partialFetch", type = EntityGraph.EntityGraphType.LOAD)
    List<PlayerEntity> findAll(Sort sort);
}
