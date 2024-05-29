package com.ms.ms_bets.infra.adapter.repository;

import com.ms.ms_bets.api.assembler.MapperDTO;
import com.ms.ms_bets.domain.model.EventResult;
import com.ms.ms_bets.domain.model.Team;
import com.ms.ms_bets.domain.port.repository.EventResultRepositoryPort;
import com.ms.ms_bets.infra.adapter.model.EventResultModel;
import com.ms.ms_bets.infra.adapter.model.TeamModel;

import java.util.Optional;

public class EventResultRepository implements EventResultRepositoryPort {

    private final MapperDTO mapper;
    private final EventResultRepositoryAccess eventResultRepositoryAccess;

    public EventResultRepository(MapperDTO mapper, EventResultRepositoryAccess eventResultRepositoryAccess) {
        this.mapper = mapper;
        this.eventResultRepositoryAccess = eventResultRepositoryAccess;
    }

    @Override
    public EventResult save(EventResult eventResult) {
        var eventResultModel = mapper.transform(eventResult, EventResultModel.class);
        eventResultModel = eventResultRepositoryAccess.save(eventResultModel);
        eventResult = mapper.transform(eventResultModel, EventResult.class);
        return eventResult;
    }

    @Override
    public Optional<EventResult> findById(Long id) {
        var eventResultModel = eventResultRepositoryAccess.findById(id);
        if(eventResultModel.isEmpty()) return Optional.empty();

        var eventResult = mapper.transform(eventResultModel, EventResult.class);
        return Optional.of(eventResult);
    }

    @Override
    public Optional<EventResult> findByEventId(Long eventId) {
        var eventResultModel = eventResultRepositoryAccess.findByEventId(eventId);
        if(eventResultModel.isEmpty()) return Optional.empty();

        var eventResult = mapper.transform(eventResultModel, EventResult.class);
        return Optional.of(eventResult);
    }


}
