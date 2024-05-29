package com.ms.ms_bets.domain.model;

public class Team {
    private Long id;
    private  String name;
    private  Sport sport;

    public Team(){}

    public Team(Long id, String name, Sport sport) {
        this.id = id;
        this.name = name;
        this.sport = sport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}
