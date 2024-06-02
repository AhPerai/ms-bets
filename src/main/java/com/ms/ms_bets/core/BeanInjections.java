package com.ms.ms_bets.core;

import com.ms.ms_bets.domain.adapter.service.BetService;
import com.ms.ms_bets.domain.adapter.service.TransactionApi;
import com.ms.ms_bets.domain.port.producer.AmqpProducer;
import com.ms.ms_bets.domain.port.repository.BetRepositoryPort;
import com.ms.ms_bets.domain.port.requets.TransactionApiPort;
import com.ms.ms_bets.domain.port.services.BetServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInjections {

    @Bean
    public BetServicePort betService(BetRepositoryPort betRepository, TransactionApiPort transactionApi, AmqpProducer betTransactionProducer){
        return new BetService(betRepository, transactionApi, betTransactionProducer);
    }

    @Bean
    public TransactionApiPort transactionApi(){
        return new TransactionApi();
    }
}
