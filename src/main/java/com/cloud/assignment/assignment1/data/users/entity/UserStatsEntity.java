package com.cloud.assignment.assignment1.data.users.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_stats", schema = "usertable")
public class UserStatsEntity {
    @Id
    @Column(insertable = false, updatable = false)
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="user_id")
    @Getter @Setter
    private Integer userId;

    @Column
    @Getter @Setter
    private Integer week;

    @Column
    @Getter @Setter
    private Integer score;

    @Column
    @Getter @Setter
    private Integer totalScore;
}
