package com.ms.ms_bets.infra.adapter.repository;

import com.ms.ms_bets.api.assembler.MapperDTO;
import com.ms.ms_bets.domain.enums.EventStatus;
import com.ms.ms_bets.domain.model.Event;
import com.ms.ms_bets.domain.port.repository.EventRepositoryPort;
import com.ms.ms_bets.infra.adapter.model.EventModel;

import java.util.List;
import java.util.Optional;

public class EventRepository implements EventRepositoryPort {

    private final MapperDTO mapper;
    private final EventRepositoryAccess eventRepositoryAccess;

    public EventRepository(MapperDTO mapper, EventRepositoryAccess eventRepositoryAccess) {
        this.mapper = mapper;
        this.eventRepositoryAccess = eventRepositoryAccess;
    }

    @Override
    public Event save(Event event) {
        var eventModel = mapper.transform(event, EventModel.class);
        eventModel = eventRepositoryAccess.save(eventModel);
        event = mapper.transform(eventModel, Event.class);
        return event;
    }

    @Override
    public Optional<Event> findById(Long id) {
        var eventModel = eventRepositoryAccess.findById(id);
        if(eventModel.isEmpty()) return Optional.empty();

        var event = mapper.transform(eventModel, Event.class);
        return Optional.of(event);
    }

    @Override
    public List<Event> findAllByStatus(EventStatus status) {
        var eventModelList = eventRepositoryAccess.findAllByStatus(status);
        return mapper.toCollection(eventModelList, Event.class);
    }

    @Override
    public List<Event> findAllByStatusAndSportId(EventStatus status, Long sportId) {
        var eventModelList = eventRepositoryAccess.findAllByStatusAndSportId(status, sportId);
        return mapper.toCollection(eventModelList, Event.class);
    }
}
