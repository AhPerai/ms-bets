package com.ms.ms_bets.domain.port.services;

import com.ms.ms_bets.domain.model.EventResult;

import java.util.Optional;

public interface EventResultServicePort {

    EventResult addEventResult(EventResult eventResult);

    Optional<EventResult> findById(Long id);
}
