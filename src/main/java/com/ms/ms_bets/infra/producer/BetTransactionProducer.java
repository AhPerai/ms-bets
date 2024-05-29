package com.ms.ms_bets.infra.producer;

import com.ms.ms_bets.domain.enums.BetStatus;
import com.ms.ms_bets.domain.model.Bet;
import com.ms.ms_bets.domain.port.producer.AmqpProducer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BetTransactionProducer implements AmqpProducer {

    final RabbitTemplate rabbitTemplate;

    public BetTransactionProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.transaction.name}")
    private String routingKey;

    public void publishMessage(Object bet){

        rabbitTemplate.convertAndSend("", routingKey, bet);

    }
}
