package com.ms.ms_bets.domain.model;

import com.ms.ms_bets.domain.enums.BetStatus;

public class Bet {
    private Long id;
    private Long idUser;
    private EventResult result;
    private Event event;
    private float odds;
    private BetStatus status;

    public Bet() {}

    public Bet(Long id, Long idUser, EventResult result, Event event, float odds, BetStatus status) {
        this.id = id;
        this.idUser = idUser;
        this.result = result;
        this.event = event;
        this.odds = odds;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public EventResult getResult() {
        return result;
    }

    public void setResult(EventResult result) {
        this.result = result;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public float getOdds() {
        return odds;
    }

    public void setOdds(float odds) {
        this.odds = odds;
    }

    public BetStatus getStatus() {
        return status;
    }

    public void setStatus(BetStatus status) {
        this.status = status;
    }
}
