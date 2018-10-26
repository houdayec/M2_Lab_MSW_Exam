package com.universita.corsica.exam.repository;

import com.universita.corsica.exam.model.LogPosition;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * Classe that interacts with database
 */
public interface LogPositionRepository extends ElasticsearchCrudRepository<LogPosition, String>{
}
