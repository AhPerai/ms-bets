package com.ms.ms_bets.infra.adapter.model;

import com.ms.ms_bets.domain.enums.PossibleResults;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "TB_SPORT")
@Entity
public class SportModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private PossibleResults result;

    private int expected_match_time;

    @OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<TeamModel> teams;

    @OneToMany(mappedBy = "event", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<EventModel> events;
}
