package com.universita.corsica.exam.service;

import com.universita.corsica.exam.model.Fish;
import com.universita.corsica.exam.model.LogPosition;
import com.universita.corsica.exam.repository.LogPositionRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
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
        LogPosition logPosition = new LogPosition().withIdFish(fish.id).withDate(Calendar.getInstance().getTimeInMillis()).withPosition(fish.position);
        logPosition = logPositionRepository.save(logPosition);
        System.out.println(logPosition);
        return logPosition;
    }

    public List<LogPosition> getLastLogsForCurrentDayById(String id){
        return logPositionRepository.findFirst5ByIdFish(id);
    }

    public List<LogPosition> get5LastLogsById(String idFish){

        /*
        Pageable pageable = new PageRequest(0, 5, Sort.Direction.ASC, "idFish");

        Page<LogPosition> topPage = logPositionRepository.findAll(pageable);
        List<LogPosition> lastLogs = topPage.getContent();
        */

        List<LogPosition> logs = new ArrayList<>();
        List<LogPosition> allLogs = new ArrayList<>();
        logPositionRepository.findAll().forEach(allLogs::add);
        for(int i=0; i < 5; i++){
            logs.add(allLogs.get(i));
        }
        return logs;
    }

    public List<LogPosition> findAll(){
        List<LogPosition> logs = new ArrayList<>();
        logPositionRepository.findAll().forEach(logs::add);
        return logs;
    }

}
