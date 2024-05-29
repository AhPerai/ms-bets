package com.ms.ms_bets.infra.producer;

import com.ms.ms_bets.api.assembler.MapperDTO;
import com.ms.ms_bets.api.dto.bet.output.BetTransactionDTO;
import com.ms.ms_bets.domain.port.producer.AmqpProducer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BetTransactionProducer implements AmqpProducer {

    final MapperDTO mapper;
    final RabbitTemplate rabbitTemplate;

    public BetTransactionProducer(MapperDTO mapper, RabbitTemplate rabbitTemplate) {
        this.mapper = mapper;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.transaction.name}")
    private String routingKey;

    public void publishMessage(Object bet){
        var transaction = mapper.transform(bet, BetTransactionDTO.class);
        rabbitTemplate.convertAndSend("", routingKey, transaction);

    }
}
