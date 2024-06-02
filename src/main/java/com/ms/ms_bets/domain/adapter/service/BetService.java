package com.ms.ms_bets.domain.adapter.service;

import com.ms.ms_bets.api.dto.transaction.input.TransactionDTO;
import com.ms.ms_bets.domain.model.Bet;
import com.ms.ms_bets.domain.port.producer.AmqpProducer;
import com.ms.ms_bets.domain.port.repository.BetRepositoryPort;
import com.ms.ms_bets.domain.port.requets.TransactionApiPort;
import com.ms.ms_bets.domain.port.services.BetServicePort;
import jakarta.persistence.EntityNotFoundException;

public class BetService implements BetServicePort {

    private final BetRepositoryPort betRepository;
    private final TransactionApiPort transactionApi;
    private final AmqpProducer betTransactionProducer;

    public BetService(BetRepositoryPort betRepository, TransactionApiPort transactionApi, AmqpProducer betTransactionProducer) {
        this.betRepository = betRepository;
        this.transactionApi = transactionApi;
        this.betTransactionProducer = betTransactionProducer;
    }

    @Override
    public Bet addBet(Bet bet){
        //Validate Transaction
        if(!transactionApi.validateBetTransaction(bet)) throw new RuntimeException();

        //createBet and Finish Transaction
        bet = betRepository.save(bet);
        TransactionDTO transaction = transactionApi.createTransaction(bet);

        //Notify Bet
        betTransactionProducer.publishMessage(bet);
        return bet;
    }

    @Override
    public Bet findBetById(Long id) {
        return betRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

}
