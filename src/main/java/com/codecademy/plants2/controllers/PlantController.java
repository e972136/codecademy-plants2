package com.codecademy.plants2.controllers;

import com.codecademy.plants2.entities.Plant;
import com.codecademy.plants2.repositories.PlantRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlantController {
    private final PlantRepository plantRepository;

    public PlantController(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @GetMapping("/plants")
    public Iterable<Plant>  getAllPlants(){
        return plantRepository.findAll();
    }
}
