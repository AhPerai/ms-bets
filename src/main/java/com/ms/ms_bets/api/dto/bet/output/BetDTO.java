package com.ms.ms_bets.api.dto.bet.output;

import com.ms.ms_bets.domain.enums.BetStatus;
import com.ms.ms_bets.domain.model.Event;
import com.ms.ms_bets.domain.model.EventResult;

public class BetDTO {
    private Long id;
    private Event event;
    private float odds;
    private double amount;
    private BetStatus status;
}
