package com.universita.corsica.exam.repository;

import com.universita.corsica.exam.model.Fish;
import com.universita.corsica.exam.model.LogPosition;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.List;

/**
 * Classe that interacts with database
 */
public interface LogPositionRepository extends ElasticsearchCrudRepository<LogPosition, Long>{

    List<LogPosition> findFirst5ByIdFish(String id);

}
