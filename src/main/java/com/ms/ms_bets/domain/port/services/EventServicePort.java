package com.ms.ms_bets.domain.port.services;

import com.ms.ms_bets.domain.model.Event;

public interface EventServicePort {

    Event addEvent(Event event);

    Event findById(Long id);

    void updateStatusEvent(Event event);

    /*Atualiza o status do Evento e Cria Event Result*/
    Event closeEvent(Event event);
}
