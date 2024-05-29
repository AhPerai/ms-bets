package com.ms.ms_bets.domain.port.services;

import com.ms.ms_bets.domain.model.Sport;

public interface SportServivePort {

    Sport addSport(Sport sport);

    Sport findById(Long id);
}
