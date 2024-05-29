package com.ms.ms_bets.domain.port.repository;

import com.ms.ms_bets.domain.enums.BetStatus;
import com.ms.ms_bets.domain.model.Bet;
import com.ms.ms_bets.domain.model.Event;

import java.util.List;
import java.util.Optional;

public interface BetRepositoryPort {
    
    Bet save(Bet bet);

    Optional<Bet> findById(Long id);

    List<Bet> findAllByEventId(Long eventId);

    List<Bet> findAllByUserId(Long userId);
}
