package com.ms.ms_bets.api.controller;

import com.ms.ms_bets.api.assembler.MapperDTO;
import com.ms.ms_bets.api.dto.bet.input.BetInputDTO;
import com.ms.ms_bets.api.dto.bet.output.BetDTO;
import com.ms.ms_bets.domain.model.Bet;
import com.ms.ms_bets.domain.port.services.BetServicePort;
import com.ms.ms_bets.infra.adapter.repository.BetRepositoryAccess;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bets")
public class BetController {

    private final MapperDTO mapper;
    private final BetRepositoryAccess betRepository;
    private final BetServicePort betService;

    public BetController(MapperDTO mapper, BetServicePort betService, BetRepositoryAccess betRepository) {
        this.mapper = mapper;
        this.betService = betService;
        this.betRepository = betRepository;
    }


    @Operation(summary = "Create a new bet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created the bet"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BetDTO createBet(
            @Parameter(description = "Bet input data", required = true, content = @Content(schema = @Schema(implementation = BetInputDTO.class)))
            @RequestBody BetInputDTO betInputDTO){
        var bet = mapper.transform(betInputDTO, Bet.class);

        bet = betService.addBet(bet);

        var betdto = mapper.transform(bet, BetDTO.class);
        return betdto;
    }

    @Operation(summary = "Find a bet by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully found the bet"),
            @ApiResponse(responseCode = "404", description = "Bet not found")
    })
    @GetMapping("/{betId}")
    public BetDTO findById(
            @Parameter(description = "Id of the bet to be retrieved", required = true)
            @PathVariable Long betId){

        var betdto = mapper.transform(betRepository.findById(betId), BetDTO.class);

        return betdto;
    }

    @Operation(summary = "Find all bets")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved all bets"),
            @ApiResponse(responseCode = "404", description = "Bets not found")
    })
    @GetMapping
    public List<BetDTO> findTransactions(){
        return mapper.toCollection(betRepository.findAll(), BetDTO.class);
    }


}
