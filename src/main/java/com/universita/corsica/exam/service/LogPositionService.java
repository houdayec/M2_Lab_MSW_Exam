package com.universita.corsica.exam.service;

import com.universita.corsica.exam.model.Fish;
import com.universita.corsica.exam.model.LogPosition;
import com.universita.corsica.exam.repository.LogPositionRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        LogPosition logPosition = new LogPosition().withIdFish(fish.id).withDate(DateTime.now()).withPosition(fish.position);
        return logPosition;
    }

}
