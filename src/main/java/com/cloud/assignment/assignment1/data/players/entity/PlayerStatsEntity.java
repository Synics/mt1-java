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

    @Column(name = "player_id")
    @Getter @Setter
    private Integer playerId;

    @Column
    @Getter @Setter
    private Integer year;

    @Column
    @Getter @Setter
    private String team;

    @Column
    @Getter @Setter
    private String position;

    @Column
    @Getter @Setter
    private Integer games;

    @Column
    @Getter @Setter
    private Integer gamesStarted;

    @Column
    @Getter @Setter
    private Integer rushing;

    @Column
    @Getter @Setter
    private Integer rushingYards;

    @Column
    @Getter @Setter
    private Integer touchdowns;

    @Column
    @Getter @Setter
    private Integer receptions;

    @Column
    @Getter @Setter
    private Integer receptionYards;
}
