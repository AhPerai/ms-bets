package com.ms.ms_bets.api.dto.bet.output;

import com.ms.ms_bets.domain.enums.BetStatus;
import com.ms.ms_bets.domain.model.Event;
import com.ms.ms_bets.domain.model.EventResult;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BetDTO {
    private Long id;
    private Long event;
    private float odds;
    private double amount;
    private BetStatus status;
}
