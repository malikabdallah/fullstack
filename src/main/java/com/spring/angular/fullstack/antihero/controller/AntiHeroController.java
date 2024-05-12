package com.spring.angular.fullstack.antihero.controller;


import com.spring.angular.fullstack.antihero.dto.AntiHeroDTO;
import com.spring.angular.fullstack.antihero.entity.AntiHeroEntity;
import com.spring.angular.fullstack.antihero.exceptions.NotFoundException;
import com.spring.angular.fullstack.antihero.service.api.AntiHeroService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/v1/antihero")
public class AntiHeroController {

    private final ModelMapper modelMapper;
    private final AntiHeroService antiHeroService;

    public AntiHeroController(ModelMapper modelMapper, AntiHeroService antiHeroService) {
        this.modelMapper = modelMapper;
        this.antiHeroService = antiHeroService;
    }

    @GetMapping("/{id}")
    private AntiHeroDTO getAntiHeroById(@PathVariable("id")UUID id) throws NotFoundException {
        AntiHeroDTO dto= convertToDTO(antiHeroService.findAntiHeroById(id));
        return dto;
    }

    @PostMapping
    public AntiHeroDTO postAntiHero(@Valid @RequestBody AntiHeroDTO antiHeroDTO){
        var entity = convertToEntity(antiHeroDTO);
        var antihero = antiHeroService.addAntiHero(entity);
        return convertToDTO(antihero);
    }

    @PutMapping("/{id}")
    public void putAntiHero(@PathVariable("id")UUID id ,@Valid @RequestBody AntiHeroDTO dto) throws NotFoundException {
        if(!id.equals(dto.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id "+id+" does not match");
        }
        var entity = convertToEntity(dto);
        antiHeroService.updateAntiHero(id,entity);
    }

    @DeleteMapping("/{id}")
    public void deleteEntityHeroById(@PathVariable("id")UUID id){
        antiHeroService.removeAntiHero(id);
    }

    @GetMapping
    public List<AntiHeroDTO> getAntiHeros(){
        var antiHeroList = StreamSupport.stream(antiHeroService.findAllAntiHero().spliterator(),false)
                .collect(Collectors.toList());

        return antiHeroList.
                stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    @GetMapping("/paging")
    public List<AntiHeroDTO> getAntiHeroPaging(Pageable pageable){
        int toSkip = pageable.getPageSize() * pageable.getPageNumber();

        var antiHeroList = StreamSupport.stream(antiHeroService.findAllAntiHero().spliterator(),false)
                .skip(toSkip).limit(pageable.getPageSize())
                .collect(Collectors.toList());

        return antiHeroList
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private AntiHeroDTO convertToDTO(AntiHeroEntity entity){
        return modelMapper.map(entity,AntiHeroDTO.class);
    }

    private AntiHeroEntity convertToEntity(AntiHeroDTO dto){
        return modelMapper.map(dto,AntiHeroEntity.class);
    }
}
