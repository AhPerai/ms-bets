package com.ms.ms_bets.domain.adapter.service;

import com.ms.ms_bets.api.dto.transaction.input.TransactionDTO;
import com.ms.ms_bets.api.dto.transaction.output.BetTransactionDTO;
import com.ms.ms_bets.api.dto.transaction.output.TransactionAmountDTO;
import com.ms.ms_bets.domain.model.Bet;
import com.ms.ms_bets.domain.port.requets.BaseRestClient;
import com.ms.ms_bets.domain.port.requets.TransactionApiPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

public class TransactionApi extends BaseRestClient implements TransactionApiPort {

    @Override
    protected void setBaseUrl() {
        BASE_URL = "http://localhost:8080/transactions";
    }

    @Override
    public boolean validateBetTransaction(Bet bet) {
        TransactionAmountDTO transaction = new TransactionAmountDTO(
                bet.getAmount(),
                "BET_PLACEMENT",
                bet.getIdUser());

        return Boolean.TRUE.equals(restClient.method(HttpMethod.GET)
                .uri("/validate")
                .body(transaction)
                .retrieve()
                .body(Boolean.class));
    }

    @Override
    public TransactionDTO createTransaction(Bet bet) {
        BetTransactionDTO transaction = new BetTransactionDTO(
                bet.getAmount(),
                "BET_PLACEMENT",
                bet.getIdUser(),
                bet.getId());

        return restClient.post()
                .uri("")
                .contentType(MediaType.APPLICATION_JSON)
                .body(transaction)
                .retrieve()
                .body(TransactionDTO.class);
    }
}
