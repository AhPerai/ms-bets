package com.ms.ms_bets.domain.port.producer;

public interface AmqpProducer {

    public void publishMessage(Object object);
}
