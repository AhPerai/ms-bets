package com.ms.ms_bets.domain.port.repository;

import com.ms.ms_bets.domain.enums.EventStatus;
import com.ms.ms_bets.domain.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventRepositoryPort {

    Event save(Event event);

    Optional<Event> findById(Long id);

    List<Event> findAllByStatus(EventStatus status);

    List<Event> findAllByStatusAndSportId(EventStatus status, Long sportId);
}
