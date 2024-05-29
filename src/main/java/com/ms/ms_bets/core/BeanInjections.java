package com.ms.ms_bets.core;

import com.ms.ms_bets.domain.adapter.service.BetService;
import com.ms.ms_bets.domain.port.services.BetServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInjections {

    @Bean
    public BetServicePort betService(){
        return new BetService();
    }
}
