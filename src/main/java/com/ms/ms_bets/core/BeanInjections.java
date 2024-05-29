package com.ms.ms_bets.core;

import com.ms.ms_bets.domain.adapter.service.BetService;
import com.ms.ms_bets.domain.adapter.service.TransactionService;
import com.ms.ms_bets.domain.port.repository.BetRepositoryPort;
import com.ms.ms_bets.domain.port.services.BetServicePort;
import com.ms.ms_bets.domain.port.services.TransactionServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInjections {

    @Bean
    public BetServicePort betService(BetRepositoryPort betRepository, TransactionServicePort transactionService){
        return new BetService(betRepository, transactionService);
    }

    @Bean
    public TransactionServicePort transactionService(){
        return new TransactionService();
    }
}
