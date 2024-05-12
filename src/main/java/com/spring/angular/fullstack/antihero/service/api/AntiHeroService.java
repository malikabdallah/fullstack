package com.spring.angular.fullstack.antihero.service.api;

import com.spring.angular.fullstack.antihero.entity.AntiHeroEntity;
import com.spring.angular.fullstack.antihero.exceptions.NotFoundException;

import java.util.UUID;

public interface AntiHeroService {

    public Iterable<AntiHeroEntity> findAllAntiHero();

    public AntiHeroEntity findAntiHeroById(UUID id) throws NotFoundException;

    public void removeAntiHero(UUID id);

    public AntiHeroEntity addAntiHero(AntiHeroEntity entity);

    public void updateAntiHero(UUID id,AntiHeroEntity entity) throws NotFoundException ;
}
