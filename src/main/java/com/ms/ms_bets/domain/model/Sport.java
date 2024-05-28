package com.ms.ms_bets.domain.model;

import com.ms.ms_bets.domain.enums.PossibleResults;

public class Sport {
    private Long id;
    private String name;
    private PossibleResults result;
    private int expected_match_time;

    public Sport(){}

    public Sport(Long id, String name, PossibleResults result, int expected_match_time) {
        this.id = id;
        this.name = name;
        this.result = result;
        this.expected_match_time = expected_match_time;
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

    public PossibleResults getResult() {
        return result;
    }

    public void setResult(PossibleResults result) {
        this.result = result;
    }

    public int getExpected_match_time() {
        return expected_match_time;
    }

    public void setExpected_match_time(int expected_match_time) {
        this.expected_match_time = expected_match_time;
    }
}
