package com.ms.ms_bets.api.dto.bet.input;

import com.ms.ms_bets.domain.enums.BetStatus;
import com.ms.ms_bets.domain.model.Event;
import com.ms.ms_bets.domain.model.EventResult;

public record BetInputDTO(Long idUser, EventResult result, Event event, float odds, double amount) {
}
