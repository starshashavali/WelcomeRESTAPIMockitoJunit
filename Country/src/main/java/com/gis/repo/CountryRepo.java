package com.gis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gis.entity.CountryEntity;

public interface CountryRepo extends JpaRepository<CountryEntity, Integer> {

}
