package com.devsuperior.bds02.service;

import com.devsuperior.bds02.model.dto.EventDTO;
import org.springframework.stereotype.Component;

@Component
public interface EventService {
    EventDTO update(Long id, EventDTO dto);
}
