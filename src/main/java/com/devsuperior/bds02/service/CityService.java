package com.devsuperior.bds02.service;

import com.devsuperior.bds02.model.dto.CityDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CityService {

    List<CityDTO> findAllSortedByName();

    CityDTO save(CityDTO dto);

    void delete(Long id);
}
