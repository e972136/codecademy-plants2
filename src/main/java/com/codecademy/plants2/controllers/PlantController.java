package com.codecademy.plants2.controllers;

import com.codecademy.plants2.entities.Plant;
import com.codecademy.plants2.repositories.PlantRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/plants/{id}")
    public Optional<Plant> getPlantById(@PathVariable Integer id){
        return plantRepository.findById(id);
    }

    @PostMapping("/plants")
    public Plant createNewPlant(@RequestBody Plant plant){
        Plant save = this.plantRepository.save(plant);
        return save;
    }

    @PutMapping("/plants/{id}")
    public Plant updatePlant(@PathVariable  Integer id, @RequestBody Plant plant){
        Optional<Plant> byId = this.plantRepository.findById(id);
        if(!byId.isPresent()){
            return null;
        }
        Plant plantToUpdate = byId.get();
        if(plant.getName()!=null)
            plantToUpdate.setName(plant.getName());

        if(plant.getQuantity()!=null)
            plantToUpdate.setQuantity(plant.getQuantity());

        if(plant.getHasFruit()!=null)
            plantToUpdate.setHasFruit(plant.getHasFruit());

        if(plant.getWateringFrequency()!=null)
            plantToUpdate.setWateringFrequency(plant.getWateringFrequency());

        Plant updatedPlant = this.plantRepository.save(plantToUpdate);
        return updatedPlant;
    }

    @DeleteMapping("/plants/{id}")
    public Plant deletePlant(@PathVariable("id") Integer id){
        Optional<Plant> plantToDeleteOptional = this.plantRepository.findById(id);
        if(!plantToDeleteOptional.isPresent()){
            return null;
        }
        Plant plantToDelete = plantToDeleteOptional.get();
        this.plantRepository.deleteById(id);
        return plantToDelete;

    }
}
