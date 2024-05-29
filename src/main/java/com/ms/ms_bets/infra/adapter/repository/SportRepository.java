package com.ms.ms_bets.infra.adapter.repository;

import com.ms.ms_bets.api.assembler.MapperDTO;
import com.ms.ms_bets.domain.model.Sport;
import com.ms.ms_bets.domain.model.Team;
import com.ms.ms_bets.domain.port.repository.SportRepositoryPort;
import com.ms.ms_bets.infra.adapter.model.SportModel;
import com.ms.ms_bets.infra.adapter.model.TeamModel;

import java.util.Optional;

public class SportRepository implements SportRepositoryPort {

    private final MapperDTO mapper;
    private final SportRepositoryAccess sportRepositoryAccess;

    public SportRepository(MapperDTO mapper, SportRepositoryAccess sportRepositoryAccess) {
        this.mapper = mapper;
        this.sportRepositoryAccess = sportRepositoryAccess;
    }

    @Override
    public Sport save(Sport sport) {
        var sportModel = mapper.transform(sport, SportModel.class);
        sportModel = sportRepositoryAccess.save(sportModel);
        sport = mapper.transform(sportModel, Sport.class);
        return sport;
    }

    @Override
    public Optional<Sport> findById(Long id) {
        var sportModel = sportRepositoryAccess.findById(id.intValue());
        if(sportModel.isEmpty()) return Optional.empty();

        var sport = mapper.transform(sportModel, Sport.class);
        return Optional.of(sport);
    }
}
