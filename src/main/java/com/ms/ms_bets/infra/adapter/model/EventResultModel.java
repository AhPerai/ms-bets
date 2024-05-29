package com.ms.ms_bets.infra.adapter.model;

import com.ms.ms_bets.domain.model.Event;
import com.ms.ms_bets.domain.model.Team;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "TB_RESULT_EVENT")
@Entity
public class EventResultModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.REMOVE)
    private EventModel event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = true)
    private TeamModel winner;

    private boolean draw;

    @OneToMany(mappedBy = "result", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<BetModel> bets;
}
