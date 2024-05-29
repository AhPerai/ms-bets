package com.ms.ms_bets.api.dto.bet.output;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BetTransactionDTO {
    private Long id;
    private Long idUser;
    private float odds;
    private double amount;
}
