package com.devsuperior.bds02.resource;

import com.devsuperior.bds02.model.dto.CityDTO;
import com.devsuperior.bds02.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cities")
public class CityResource {

    @Autowired
    private CityService service;

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAllSortedByName(){

        List<CityDTO> list = service.findAllSortedByName();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<CityDTO> save(
            @RequestBody CityDTO dto
    ){
        CityDTO cityDTO = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cityDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CityDTO> delete(
            @PathVariable Long id
    ){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
