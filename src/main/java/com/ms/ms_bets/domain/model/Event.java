package com.ms.ms_bets.domain.model;

import com.ms.ms_bets.domain.enums.EventStatus;

import java.time.LocalDateTime;

public class Event {
    private Long id;
    private Sport sport;
    private String description;
    private EventStatus status;
    private LocalDateTime started_at;

    public Event() {}

    public Event(Long id, Sport sport, String description, EventStatus status, LocalDateTime started_at) {
        this.id = id;
        this.sport = sport;
        this.description = description;
        this.status = status;
        this.started_at = started_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public LocalDateTime getStarted_at() {
        return started_at;
    }

    public void setStarted_at(LocalDateTime started_at) {
        this.started_at = started_at;
    }

    public LocalDateTime getApproximateEndTime() {
        return started_at.plusMinutes(sport.getExpected_match_time());
    }

    public boolean isLikelyOver() {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(getApproximateEndTime());
    }
}
