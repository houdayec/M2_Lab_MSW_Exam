package com.universita.corsica.exam.controller;

import com.universita.corsica.exam.model.Fish;
import com.universita.corsica.exam.model.LogPosition;
import com.universita.corsica.exam.service.LogPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/positions")
@Validated
public class LogPositionController {

    @Autowired
    private LogPositionService logPositionService;

    @GetMapping
    public ResponseEntity<List<LogPosition>> getAllLogs(){
        List<LogPosition> logs = logPositionService.findAll();
        if(!logs.isEmpty()){ // If fish were found
            return ResponseEntity.ok(logs);
        }else{ // Otherwise throw 404 error
            return ResponseEntity.notFound().build();
        }
    }

}
