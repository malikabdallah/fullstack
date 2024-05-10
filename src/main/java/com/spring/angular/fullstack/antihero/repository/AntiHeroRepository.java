package com.spring.angular.fullstack.antihero.repository;

import com.spring.angular.fullstack.antihero.entity.AntiHeroEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AntiHeroRepository extends CrudRepository<AntiHeroEntity, UUID> {
}
