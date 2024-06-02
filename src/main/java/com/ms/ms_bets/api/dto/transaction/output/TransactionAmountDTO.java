package com.ms.ms_bets.api.dto.transaction.output;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TransactionAmountDTO(@Positive double amount,
                                @NotNull String transactionType,
                                @NotNull Long userId) {
}