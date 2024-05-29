package com.ms.ms_bets.infra.adapter.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "TB_TEAM")
@Entity
public class TeamModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;

    private  String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private SportModel sport;

    @ManyToMany(mappedBy = "teams")
    private Set<EventModel> events;

    @OneToMany(mappedBy = "winner", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<EventResultModel> wonEvents;
}
