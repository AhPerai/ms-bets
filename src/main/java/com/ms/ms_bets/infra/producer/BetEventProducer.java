package com.ms.ms_bets.infra.producer;


import com.ms.ms_bets.domain.enums.BetStatus;
import com.ms.ms_bets.domain.model.Bet;
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

        var betStatus = bet.getStatus().getDescricao();
        var betOdd = bet.getOdds();
        var betValue = bet.getAmount();
        var betTotal = (bet.getOdds() * bet.getAmount());
        var betProfit = betTotal - betValue;

        var resultText = bet.getStatus() == BetStatus.WON ?
                """
                A partir de uma odd de %.2f em uma aposta de R$%.2f foram retornados R$%.2f, gerando lucro de R$%.2f
                """.formatted( betOdd, betValue, betTotal, betProfit)
                :
                """
                Infelizmente, a partir de uma odd de %.2f em uma aposta de R$%.2f não houve retorno de valores devido a resolução da aposta. 
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
