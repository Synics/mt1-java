package com.cloud.assignment.assignment1.data.users.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users", schema = "usertable")
public class UserEntity {
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
    private String email;

    @Column
    @Getter @Setter
    private String username;

    @Column
    @Getter @Setter
    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Getter @Setter
    private Set<UserStatsEntity> userStatsEntity;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter @Setter
    private UserTeamEntity userTeam;
}
