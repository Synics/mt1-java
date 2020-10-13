package com.cloud.assignment.assignment1.data.users.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.util.Set;

@NamedEntityGraphs(
        @NamedEntityGraph(
                name = "graph.UserEntity.fullFetch",
                attributeNodes = {
                        @NamedAttributeNode(value = "userStats"),
                        @NamedAttributeNode(value = "userTeam", subgraph = "subgraph.UserTeamEntity.fullFetch")
                },
                subgraphs = {
                        @NamedSubgraph(
                                name = "subgraph.UserTeamEntity.fullFetch",
                                attributeNodes = {
                                        @NamedAttributeNode(value = "quarterback"),
                                        @NamedAttributeNode(value = "runningBack1"),
                                        @NamedAttributeNode(value = "runningBack2"),
                                        @NamedAttributeNode(value = "wideReceiver1"),
                                        @NamedAttributeNode(value = "wideReceiver2"),
                                        @NamedAttributeNode(value = "tightEnd")
                                }
                        ),
                }
        )
)
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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @Getter @Setter
    private Set<UserStatsEntity> userStats;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter @Setter
    private UserTeamEntity userTeam;
}
