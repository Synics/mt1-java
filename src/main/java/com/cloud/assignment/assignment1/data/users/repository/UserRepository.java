package com.cloud.assignment.assignment1.data.users.repository;

import com.cloud.assignment.assignment1.data.users.entity.UserEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Query("SELECT o from UserEntity o where o.username = ?1")
    List<UserEntity> findByUsername(String userName, Sort sort);
}
