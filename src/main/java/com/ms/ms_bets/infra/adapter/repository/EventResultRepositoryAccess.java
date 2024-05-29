package com.ms.ms_bets.infra.adapter.repository;

import com.ms.ms_bets.infra.adapter.model.EventResultModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventResultRepositoryAccess extends JpaRepository<EventResultModel, Long> {

    Optional<EventResultModel> findByEventId(Long eventId);
}
