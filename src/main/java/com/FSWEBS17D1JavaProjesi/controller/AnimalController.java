package com.FSWEBS17D1JavaProjesi.controller;


import com.FSWEBS17D1JavaProjesi.entities.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    private final Map<Integer, Animal> animalMap = new HashMap<>();

    @GetMapping("/")
    public List<Animal> get() {
        return animalMap.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal get(@PathVariable int id) {

        return animalMap.get(id);
    }

    @PostMapping("/")
    public Animal post(@RequestBody Animal animal) {
        animalMap.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/{id}")
    public Animal put(@PathVariable int id, @RequestBody Animal animal) {

        Animal newAnimal = new Animal(id, animal.getName());
        animalMap.put(id, newAnimal);
        return newAnimal;
    }

    @DeleteMapping("/{id}")
    public Animal delete(@PathVariable int id) {

        return animalMap.remove(id);
    }


}
