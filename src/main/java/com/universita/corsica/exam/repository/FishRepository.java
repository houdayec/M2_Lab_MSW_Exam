package com.universita.corsica.exam.repository;

import com.universita.corsica.exam.model.Fish;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.List;

/**
 * Class that interacts with database
 */
public interface FishRepository extends ElasticsearchCrudRepository<Fish, String> {

    /**
     * BASIC CRUD
     */
    Fish deleteFishById(String id);
    Fish findById(Fish fish);
    List<Fish> findByProtected(boolean isProtected);

}
