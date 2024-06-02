package com.ms.ms_bets.api.controller;

import com.ms.ms_bets.api.assembler.MapperDTO;
import com.ms.ms_bets.api.dto.bet.input.BetInputDTO;
import com.ms.ms_bets.api.dto.bet.output.BetDTO;
import com.ms.ms_bets.domain.model.Bet;
import com.ms.ms_bets.domain.port.services.BetServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bets")
public class BetController {

    private final MapperDTO mapper;
    private final BetServicePort betService;

    public BetController(MapperDTO mapper, BetServicePort betService) {
        this.mapper = mapper;
        this.betService = betService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BetDTO createBet(@RequestBody BetInputDTO betInputDTO){
        var bet = mapper.transform(betInputDTO, Bet.class);

        bet = betService.addBet(bet);

        var betdto = mapper.transform(bet, BetDTO.class);
        return betdto;
    }

    @GetMapping("/{betId}")
    public BetDTO findById(@PathVariable Long betId){
        return mapper.transform(betService.findBetById(betId), BetDTO.class);
    }
}
