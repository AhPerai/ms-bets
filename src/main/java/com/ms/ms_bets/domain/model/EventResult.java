package com.ms.ms_bets.domain.model;

public class EventResult {
    private Long id;
    private Event event;
    private Team winner;
    private boolean draw;

    public EventResult(){}

    public EventResult(Long id, Event event, Team winner, boolean draw) {
        this.id = id;
        this.event = event;
        this.winner = winner;
        this.draw = draw;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public boolean isDraw() {
        return draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }
}
