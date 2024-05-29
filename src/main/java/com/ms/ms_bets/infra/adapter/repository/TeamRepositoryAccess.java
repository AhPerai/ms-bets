package com.ms.ms_bets.infra.adapter.repository;

import com.ms.ms_bets.infra.adapter.model.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepositoryAccess extends JpaRepository<TeamModel, Integer> {
}
