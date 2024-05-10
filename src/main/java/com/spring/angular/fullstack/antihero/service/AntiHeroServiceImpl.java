package com.spring.angular.fullstack.antihero.service;

import com.spring.angular.fullstack.antihero.entity.AntiHeroEntity;
import com.spring.angular.fullstack.antihero.repository.AntiHeroRepository;
import com.spring.angular.fullstack.antihero.service.api.AntiHeroService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AntiHeroServiceImpl implements AntiHeroService {

    private final AntiHeroRepository antiHeroRepository;

    public AntiHeroServiceImpl(AntiHeroRepository antiHeroRepository){
        this.antiHeroRepository=antiHeroRepository;
    }


    @Override
    public Iterable<AntiHeroEntity> findAllAntiHero() {
        return antiHeroRepository.findAll();
    }

    @Override
    public AntiHeroEntity findAntiHeroById(UUID id) {
        return antiHeroRepository.findById(id).get();
    }

    @Override
    public void removeAntiHero(UUID id) {
        antiHeroRepository.deleteById(id);
    }

    @Override
    public AntiHeroEntity addAntiHero(AntiHeroEntity entity) {
        return antiHeroRepository.save(entity);
    }

    @Override
    public void updateAntiHero(UUID id, AntiHeroEntity entity) {
        antiHeroRepository.save(entity);
    }
}
