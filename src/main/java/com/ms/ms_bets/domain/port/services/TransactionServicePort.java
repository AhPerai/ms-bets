package com.ms.ms_bets.domain.port.services;

import com.ms.ms_bets.domain.model.Bet;

public interface TransactionServicePort {
    boolean isValid(Bet bet);
}
