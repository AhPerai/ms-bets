package com.ms.ms_bets.api.dto.transaction.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TransactionDTO {
    private Long id;
    private double amount;
    private String type;
    private LocalDateTime dateTime;
    private Long idBet;
}