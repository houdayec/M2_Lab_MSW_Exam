package com.universita.corsica.exam.repository;

import com.universita.corsica.exam.model.Fish;
import com.universita.corsica.exam.model.LogPosition;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import sun.rmi.runtime.Log;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Classe that interacts with database
 */
public interface LogPositionRepository extends ElasticsearchCrudRepository<LogPosition, String>{

    List<LogPosition> findFirst5ByIdFish(String id);

}
