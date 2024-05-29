package com.ms.ms_bets.domain.adapter.service;

import com.ms.ms_bets.domain.model.Bet;
import com.ms.ms_bets.domain.port.services.TransactionServicePort;

public class TransactionService implements TransactionServicePort {



    @Override
    public boolean isValid(Bet bet){
        //TODO: restTemplate para chamar api de transactions
        return true;
    }

}
