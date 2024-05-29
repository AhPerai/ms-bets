package com.ms.ms_bets.domain.adapter.service;

import com.ms.ms_bets.domain.model.Bet;
import com.ms.ms_bets.domain.port.producer.AmqpProducer;
import com.ms.ms_bets.domain.port.repository.BetRepositoryPort;
import com.ms.ms_bets.domain.port.services.BetServicePort;
import com.ms.ms_bets.domain.port.services.TransactionServicePort;
import com.ms.ms_bets.infra.producer.BetTransactionProducer;

public class BetService implements BetServicePort {

    private final BetRepositoryPort betRepository;
    private final TransactionServicePort transactionService;
    private final AmqpProducer betTransactionProducer;
    public BetService(BetRepositoryPort betRepository, TransactionServicePort transactionService, AmqpProducer betTransactionProducer) {
        this.betRepository = betRepository;
        this.transactionService = transactionService;
        this.betTransactionProducer = betTransactionProducer;
    }

    @Override
    public Bet addBet(Bet bet){
        var validBet = transactionService.isValid(bet);
        if(!validBet) throw new RuntimeException();

        bet = betRepository.save(bet);
        betTransactionProducer.publishMessage(bet);

        return bet;
    }
}
