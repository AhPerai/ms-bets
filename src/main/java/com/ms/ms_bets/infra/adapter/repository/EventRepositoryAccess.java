package com.ms.ms_bets.infra.adapter.repository;

import com.ms.ms_bets.domain.enums.EventStatus;
import com.ms.ms_bets.infra.adapter.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepositoryAccess extends JpaRepository<EventModel, Long> {

    List<EventModel> findAllByStatus(EventStatus status);

    List<EventModel> findAllByStatusAndSportId(EventStatus status, Long sportId);
}
