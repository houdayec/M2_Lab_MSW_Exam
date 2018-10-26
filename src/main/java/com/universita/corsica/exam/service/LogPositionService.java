package com.universita.corsica.exam.service;

import com.universita.corsica.exam.model.Fish;
import com.universita.corsica.exam.model.LogPosition;
import com.universita.corsica.exam.repository.LogPositionRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that interacts with user repository
 */

@Service
public class LogPositionService {

    @Autowired
    private LogPositionRepository logPositionRepository;

    /**
     * IMPLEM CRUD
     */
    public LogPosition generateLogFor(Fish fish){
        System.out.println("last id " + logPositionRepository.findTopByOrderByIdDesc().id);
        LogPosition logPosition = new LogPosition().withId(logPositionRepository.findTopByOrderByIdDesc().id++).withIdFish(fish.id).withDate(DateTime.now().dayOfYear().getDateTime()).withPosition(fish.position);
        logPositionRepository.save(logPosition);
        System.out.println(logPosition);
        return logPosition;
    }

    public List<LogPosition> getLastLogsForCurrentDayById(String id){
        return logPositionRepository.findFirst5ByIdFish(id);
    }

    public List<LogPosition> findAll(){
        List<LogPosition> logs = new ArrayList<>();
        logPositionRepository.findAll().forEach(logs::add);
        return logs;
    }

}
