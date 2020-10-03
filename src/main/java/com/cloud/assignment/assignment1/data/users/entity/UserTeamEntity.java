package com.cloud.assignment.assignment1.data.users.entity;

import com.cloud.assignment.assignment1.data.players.entity.PlayerEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_teams", schema = "usertable")
public class UserTeamEntity {
    @Id
    @Column(insertable = false, updatable = false)
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity user;

    @Column(name="user_id")
    @Getter @Setter
    private Integer userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "quarterback_id", referencedColumnName = "id")
    @Getter @Setter
    private PlayerEntity quarterback;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "running_back1_id", referencedColumnName = "id")
    @Getter @Setter
    private PlayerEntity runningBack1;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "running_back2_id", referencedColumnName = "id")
    @Getter @Setter
    private PlayerEntity runningBack2;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wide_receiver1_id", referencedColumnName = "id")
    @Getter @Setter
    private PlayerEntity wideReceiver1;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wide_receiver2_id", referencedColumnName = "id")
    @Getter @Setter
    private PlayerEntity wideReceiver2;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tight_end_id", referencedColumnName = "id")
    @Getter @Setter
    private PlayerEntity tightEnd;
}
