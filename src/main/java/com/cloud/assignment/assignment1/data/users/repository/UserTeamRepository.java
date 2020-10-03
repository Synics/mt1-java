package com.cloud.assignment.assignment1.data.users.repository;

import com.cloud.assignment.assignment1.data.users.entity.UserTeamEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserTeamRepository extends JpaRepository<UserTeamEntity, Integer> {

}
