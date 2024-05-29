package com.ms.ms_bets.domain.port.repository;

import com.ms.ms_bets.domain.model.EventResult;

import java.util.List;
import java.util.Optional;

public interface EventResultRepositoryPort {

    EventResult save(EventResult eventResult);

    Optional<EventResult> findById(Long id);

    Optional<EventResult> findByEventId(Long eventId);
}
