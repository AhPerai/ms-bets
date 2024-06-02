package com.ms.ms_bets.domain.port.requets;


import com.ms.ms_bets.api.dto.transaction.input.TransactionDTO;
import com.ms.ms_bets.api.dto.transaction.output.BetTransactionDTO;
import com.ms.ms_bets.domain.model.Bet;

public interface TransactionApiPort {

    boolean validateBetTransaction(Bet bet);
    TransactionDTO createTransaction(Bet bet);
}
