package com.ms.ms_bets.infra.adapter.model;

import com.ms.ms_bets.domain.enums.BetStatus;

import jakarta.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "TB_BET")
@Entity
public class BetModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, unique = true)
    private Long idUser;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = true)
    private EventResultModel result;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private EventModel event;

    private float odds;

    @Enumerated(EnumType.STRING)
    private BetStatus status;
}
