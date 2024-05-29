package com.ms.ms_bets.infra.producer;


import com.ms.ms_bets.domain.enums.BetStatus;
import com.ms.ms_bets.domain.model.Bet;
import com.ms.users.domain.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BetEventProducer {

    final RabbitTemplate rabbitTemplate;

    public BetEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessage(Bet bet, String userName, String userEmail){
        record EmailDTO(String emailTo, String subject, String text){}

        var betStatus = bet.getStatus().name();
        var betOdd = bet.getOdds();
        var betValue = bet.getValue();
        var betTotal = (bet.getOdds() * bet.getValue());
        var betProfit = betTotal - betValue;

        var resultText = bet.getStatus() == BetStatus.WON ?
                """
                A partir de uma odd de %d em uma aposta de R$%d foram retornados R$%d, gerando lucro de R$%d
                """.formatted( betOdd, betValue, betTotal, betProfit)
                :
                """
                Infelizmente, a partir de uma odd de %d em uma aposta de R$%d não houve retorno de valores devido a resolução da aposta. 
                """.formatted(betOdd, betValue);

        String emailText = """
                Olá, %s
                
                Sua aposta foi resolvida como %s!
                %s. Para mais informações acesse https://betstracker.com.br/
                """.formatted(userName, betStatus, resultText);

        var emailDTO = new EmailDTO(userEmail, "Resultados da aposta disponível!", emailText);

        rabbitTemplate.convertAndSend("", routingKey, emailDTO);

    }
}
