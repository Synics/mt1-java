package com.cloud.assignment.assignment1.data.players.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
}
