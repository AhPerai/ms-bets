package com.ms.ms_bets.domain.adapter.service;

import com.ms.ms_bets.domain.model.Bet;
import com.ms.ms_bets.domain.port.repository.BetRepositoryPort;
import com.ms.ms_bets.domain.port.services.BetServicePort;
import com.ms.ms_bets.domain.port.services.TransactionServicePort;

public class BetService implements BetServicePort {

    private final BetRepositoryPort betRepository;
    private final TransactionServicePort transactionService;

    public BetService(BetRepositoryPort betRepository, TransactionServicePort transactionService) {
        this.betRepository = betRepository;
        this.transactionService = transactionService;
    }

    @Override
    public Bet addBet(Bet bet){
        var validBet = transactionService.isValid(bet);
        if(!validBet) throw new RuntimeException();

        bet = betRepository.save(bet);

        //TODO: criar fila para ms-transaction processar dados de bets criadas
        return bet;
    }
}
