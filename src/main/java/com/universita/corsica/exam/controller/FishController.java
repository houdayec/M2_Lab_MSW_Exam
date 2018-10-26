package com.universita.corsica.exam.controller;

import com.universita.corsica.exam.model.Fish;
import com.universita.corsica.exam.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/fish")
@Validated
public class FishController {

    @Autowired
    private FishService fishService;

    @GetMapping
    public ResponseEntity<List<Fish>> getAllFish(){
        List<Fish> foundFish = fishService.findAll();
        if(!foundFish.isEmpty()){ // If fish were found
            return ResponseEntity.ok(foundFish);
        }else{ // Otherwise throw 404 error
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fish> getFishById(@PathVariable("id") String id){
        Fish foundFish = fishService.findById(id);
        if(!foundFish.equals(null)){ // If fish was found
            return ResponseEntity.ok(foundFish);
        }else{ // Otherwise throw 404 error
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Fish> addFish(@RequestBody Fish fish){
        return ResponseEntity.ok(fishService.addFish(fish));
    }

    @PutMapping
    public ResponseEntity<Fish> updateFish(@RequestBody Fish fish){
        Fish foundFish = fishService.findById(fish.id);
        if(!foundFish.equals(null)){ // If fish was found
            return ResponseEntity.ok(fishService.updateFish(fish));
        }else{ // Otherwise throw 404 error
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(("/{id}"))
    public ResponseEntity<Fish> deleteFish(@PathVariable("id") String id) {
        Fish foundFish = fishService.findById(id);
        if (!foundFish.equals(null)) { // If fish was found
            return ResponseEntity.ok(fishService.removeFish(id));
        } else { // Otherwise throw 404 error
            return ResponseEntity.notFound().build();
        }

    }

}
