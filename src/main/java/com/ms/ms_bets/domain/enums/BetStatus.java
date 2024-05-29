package com.ms.ms_bets.domain.enums;

import com.ms.ms_bets.domain.model.Bet;

public enum BetStatus {

    PENDING("Pendente"),
    LOST("Perda"),
    WON("Ganho");

    private String descricao;
    BetStatus(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }
}
