package com.cloud.assignment.assignment1.data.users.repository;

import com.cloud.assignment.assignment1.data.users.entity.UserStatsEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserStatsRepository extends JpaRepository<UserStatsEntity, Integer> {
    @Query("SELECT o from UserStatsEntity o where o.userId = ?1")
    List<UserStatsEntity> findByUserId(Integer userId, Sort sort);
}
