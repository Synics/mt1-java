package com.cloud.assignment.assignment1.data.players.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "player_stats", schema = "players")
public class PlayerStatsEntity {
    @Id
    @Column(insertable = false, updatable = false)
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Getter @Setter
    private Integer playerId;

    @Column
    @Getter @Setter
    private Integer week;

    @Column
    @Getter @Setter
    private Integer score;
}
