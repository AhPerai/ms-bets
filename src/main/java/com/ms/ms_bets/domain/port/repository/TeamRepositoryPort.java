package com.ms.ms_bets.domain.port.repository;

import com.ms.ms_bets.domain.model.Team;

import java.util.Optional;

public interface TeamRepositoryPort {
    Team save(Team team);

    Optional<Team> findById(Long id);
}
