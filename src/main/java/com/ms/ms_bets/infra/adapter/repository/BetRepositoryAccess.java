package com.ms.ms_bets.infra.adapter.repository;

import com.ms.ms_bets.infra.adapter.model.BetModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BetRepositoryAccess extends JpaRepository<BetModel, Integer> {

    List<BetModel> findAllByEventId(Long eventId);

    List<BetModel> findAllByIdUser(Long userId);

}
