package com.ms.ms_bets.infra.adapter.model;

import com.ms.ms_bets.domain.enums.EventStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "TB_EVENT")
@Entity
public class EventModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private SportModel sport;

    private String description;

    @Enumerated(EnumType.STRING)
    private EventStatus status;

    private LocalDateTime started_at;

    @ManyToMany
    @JoinTable(
            name = "team_event",
            joinColumns = @JoinColumn(name = "id_event", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_team", nullable = false)
    )
    private Set<TeamModel> teams;

    @OneToOne(optional = false, cascade = CascadeType.REMOVE)
    private EventResultModel result;

    @OneToMany(mappedBy = "event", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<BetModel> bets;
}
