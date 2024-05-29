package com.ms.ms_bets;

import com.ms.ms_bets.domain.enums.BetStatus;
import com.ms.ms_bets.domain.model.Bet;
import com.ms.ms_bets.domain.model.Event;
import com.ms.ms_bets.domain.model.EventResult;
import com.ms.ms_bets.infra.producer.BetEventProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private BetEventProducer betEventProducer;

    @Test
    public void shouldSucceedWhenEmailSentWithAllData(){
        var bet = new Bet(1L, 1L, new EventResult(), new Event(), 1.5f, 50.00, BetStatus.LOST);

        betEventProducer.publishMessage(bet, "Lucas", "luukascastro@gmail.com");
    }
}
