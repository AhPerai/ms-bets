package com.ms.ms_bets.domain.port.repository;

import com.ms.ms_bets.domain.model.Sport;

import java.util.Optional;

public interface SportRepositoryPort {

    Sport save(Sport sport);

    Optional<Sport> findById(Long id);
}
