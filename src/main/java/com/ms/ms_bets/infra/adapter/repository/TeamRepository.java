package com.ms.ms_bets.infra.adapter.repository;

import com.ms.ms_bets.api.assembler.MapperDTO;
import com.ms.ms_bets.domain.model.Team;
import com.ms.ms_bets.domain.port.repository.TeamRepositoryPort;
import com.ms.ms_bets.infra.adapter.model.TeamModel;

import java.util.Optional;

public class TeamRepository implements TeamRepositoryPort {

    private final TeamRepositoryAccess teamRepositoryAccess;
    private final MapperDTO mapper;

    public TeamRepository(TeamRepositoryAccess teamRepositoryAccess, MapperDTO mapper) {
        this.teamRepositoryAccess = teamRepositoryAccess;
        this.mapper = mapper;
    }

    @Override
    public Team save(Team team) {
        var teamModel = mapper.transform(team, TeamModel.class);
        teamModel = teamRepositoryAccess.save(teamModel);
        team = mapper.transform(teamModel, Team.class);
        return team;
    }

    @Override
    public Optional<Team> findById(Long id) {
        var teamModel = teamRepositoryAccess.findById(id.intValue());
        if(teamModel.isEmpty()) return Optional.empty();
        var team = mapper.transform(teamModel, Team.class);
        return Optional.of(team);
    }
}
