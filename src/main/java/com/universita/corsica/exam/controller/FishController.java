package com.universita.corsica.exam.controller;

import com.universita.corsica.exam.model.Fish;
import com.universita.corsica.exam.model.LogPosition;
import com.universita.corsica.exam.service.FishService;
import com.universita.corsica.exam.service.LogPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
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

    @Autowired
    private LogPositionService logPositionService;

    @GetMapping
    public ResponseEntity<List<Fish>> getAllFish(){
        List<Fish> foundFish = fishService.findAll();
        if(!foundFish.isEmpty()){ // If fish were found
            return ResponseEntity.ok(foundFish);
        }else{ // Otherwise throw 404 error
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/allowed")
    public ResponseEntity<List<Fish>> getAllFishWithRestriction(){
        List<Fish> foundFish = fishService.findAllRestricted();
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

    @GetMapping("/{id}/positions")
    public ResponseEntity<List<LogPosition>> getLogs(@PathVariable("id") String id){
        List<LogPosition> logs = logPositionService.get5LastLogsById(id);
        if(!logs.isEmpty()){ // If fish was found
            return ResponseEntity.ok(logs);
        }else { // Otherwise throw 404 error
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/fish-count")
    public ResponseEntity<Integer> getAllFishesByRadius(@RequestParam("latlng")Double[] latlng,
                                                           @RequestParam(value = "radius", defaultValue = "4km") String radius) {
        if (latlng != null) {
            return ResponseEntity.ok(fishService.findByRadius(new GeoPoint(latlng[0], latlng[1]), radius).size());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<Fish> addFish(@RequestBody Fish fish){
        Fish addedFish = fishService.addFish(fish);
        logPositionService.generateLogFor(fish);
        return ResponseEntity.ok(addedFish);
    }

    @PutMapping
    public ResponseEntity<Fish> updateFish(@RequestBody Fish fish){
        logPositionService.generateLogFor(fish);
        Fish updatedFish = fishService.updateFish(fish);
        if(!updatedFish.equals(null)){ // If fish was found
            return ResponseEntity.ok(updatedFish);
        }else{ // Otherwise throw 404 error
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(("/{id}"))
    public ResponseEntity<Fish> deleteFish(@PathVariable("id") String id) {
        Fish removedFish = fishService.removeFish(id);
        if (!removedFish.equals(null)) { // If fish was found
            return ResponseEntity.ok(removedFish);
        } else { // Otherwise throw 404 error
            return ResponseEntity.notFound().build();
        }
    }

}
