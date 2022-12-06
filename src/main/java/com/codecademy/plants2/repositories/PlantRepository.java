package com.codecademy.plants2.repositories;

import com.codecademy.plants2.entities.Plant;
import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<Plant,Integer> {
}
