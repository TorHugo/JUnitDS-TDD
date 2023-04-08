package com.devsuperior.bds02.resource;

import com.devsuperior.bds02.model.dto.EventDTO;
import com.devsuperior.bds02.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/events")
public class EventResource {

    @Autowired
    private EventService service;

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> update(
            @PathVariable Long id, @RequestBody EventDTO dto
    ) {
        EventDTO eventDTO = service.update(id, dto);
        return ResponseEntity.ok().body(eventDTO);
    }
}
