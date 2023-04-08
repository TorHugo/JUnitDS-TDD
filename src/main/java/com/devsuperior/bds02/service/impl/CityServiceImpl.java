package com.devsuperior.bds02.service.impl;

import com.devsuperior.bds02.exception.impl.DataBaseException;
import com.devsuperior.bds02.exception.impl.ResourceNotFoundException;
import com.devsuperior.bds02.model.dto.CityDTO;
import com.devsuperior.bds02.model.entities.City;
import com.devsuperior.bds02.repository.CityRepository;
import com.devsuperior.bds02.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository repository;

    @Override
    public List<CityDTO> findAllSortedByName() {
        final List<City> lsCities = repository.findAll(Sort.by("name"));
        return lsCities.stream().map(CityDTO::new).collect(Collectors.toList());
    }

    @Override
    public CityDTO save(CityDTO dto) {
        City city = mapperToEntity(dto);
        return new CityDTO(repository.save(city));
    }

    @Override
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id not found: " + id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException("Integrity violation!");
        }
    }

    private City mapperToEntity(CityDTO dto) {
        City entity = new City();
        entity.setName(dto.getName());
        return entity;
    }
}
