package com.devsuperior.bds02.service.impl;

import com.devsuperior.bds02.model.dto.EventDTO;
import com.devsuperior.bds02.model.entities.Event;
import com.devsuperior.bds02.repository.CityRepository;
import com.devsuperior.bds02.repository.EventRepository;
import com.devsuperior.bds02.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository repository;

    @Autowired
    private CityRepository cityRepository;


    @Override
    public EventDTO update(Long id, EventDTO dto) {

        Event entity = mapperToEntity(id, dto);
        return new EventDTO(repository.save(entity));
    }

    private Event mapperToEntity(Long id, EventDTO dto) {
        Event entity = new Event();
        entity.setId(id);
        entity.setName(dto.getName());
        entity.setUrl(dto.getUrl());
        entity.setDate(dto.getDate());
        entity.setCity(
                cityRepository.findById(dto.getCityId()).orElseThrow());

        return entity;
    }
}
