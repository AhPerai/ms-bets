package com.ms.ms_bets.infra.adapter.repository;

import com.ms.ms_bets.infra.adapter.model.SportModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepositoryAccess extends JpaRepository<SportModel, Integer> {
}
