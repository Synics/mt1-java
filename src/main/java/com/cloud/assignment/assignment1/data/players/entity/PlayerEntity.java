package com.cloud.assignment.assignment1.data.players.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NamedEntityGraph( name="graph.playerEntity.partialFetch",
        attributeNodes = {
                @NamedAttributeNode("stats"),
                @NamedAttributeNode("rushRecStats"),
                @NamedAttributeNode("passingStats")
        }
)

@Entity
@Table(name = "player", schema = "players")
public class PlayerEntity {
    @Id
    @Column(insertable = false, updatable = false)
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Getter @Setter
    private String firstName;

    @Column
    @Getter @Setter
    private String lastName;

    @Column
    @Getter @Setter
    private String fieldPosition;

    @Column
    @Getter @Setter
    private String team;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", referencedColumnName = "id", updatable = false, insertable = false)
    @Getter @Setter
    private Set<PlayerWeeklyStatsEntity> stats;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", referencedColumnName = "id", updatable = false, insertable = false)
    @Getter @Setter
    private Set<PlayerStatsEntity> rushRecStats;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", referencedColumnName = "id", updatable = false, insertable = false)
    @Getter @Setter
    private Set<QBStatsEntity> passingStats;
}
