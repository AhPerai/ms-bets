package com.ms.ms_bets.infra.adapter.repository;

import com.ms.ms_bets.api.assembler.MapperDTO;
import com.ms.ms_bets.domain.model.Bet;
import com.ms.ms_bets.domain.model.Event;
import com.ms.ms_bets.domain.port.repository.BetRepositoryPort;
import com.ms.ms_bets.infra.adapter.model.BetModel;
import com.ms.ms_bets.infra.adapter.model.EventModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BetRepository implements BetRepositoryPort {

    private final MapperDTO mapper;
    private final BetRepositoryAccess betRepositoryAccess;

    public BetRepository(MapperDTO mapper, BetRepositoryAccess betRepositoryAccess) {
        this.mapper = mapper;
        this.betRepositoryAccess = betRepositoryAccess;
    }

    @Override
    public Bet save(Bet bet) {
        var betModel = mapper.transform(bet, BetModel.class);
        betModel = betRepositoryAccess.save(betModel);

        bet = mapper.transform(betModel, Bet.class);
        return bet;
    }

    @Override
    public Optional<Bet> findById(Long id) {
        var betModel = betRepositoryAccess.findById(id);
        if(betModel.isEmpty()) return Optional.empty();

        var bet = mapper.transform(betModel, Bet.class);
        return Optional.of(bet);
    }

    @Override
    public List<Bet> findAllByEventId(Long eventId) {
        var eventModelList = betRepositoryAccess.findAllByEventId(eventId);
        return mapper.toCollection(eventModelList, Bet.class);
    }

    @Override
    public List<Bet> findAllByUserId(Long userId) {
        var eventModelList = betRepositoryAccess.findAllByIdUser(userId);
        return mapper.toCollection(eventModelList, Bet.class);
    }
}
