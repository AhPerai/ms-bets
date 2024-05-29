package com.ms.ms_bets.domain.port.services;

import com.ms.ms_bets.domain.model.Team;

public interface TeamServicePort {

    Team addTeam(Team team);

    Team findById(Long id);
}
