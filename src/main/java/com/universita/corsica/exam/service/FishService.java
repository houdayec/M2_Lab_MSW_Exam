package com.universita.corsica.exam.service;

import com.universita.corsica.exam.model.Fish;
import com.universita.corsica.exam.repository.FishRepository;
import com.universita.corsica.exam.repository.LogPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class that interacts with fish repository
 */

@Service
public class FishService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private FishRepository fishRepository;

    @PostConstruct
    public void fakeDBPopulate(){
        int[] ages = new int [] {15, 27, 15, 12, 27, 6};
        String[] t = new String [] { "houdayer.corentin@gmail.com", "cyril.niobe@gmail.com", "anthony.seve@gmail.com", "mathieu.puertas@gmail.com", "melissa.llorens@gmail.com", "thomas.milioni@gmail.com", "emilie.aslan@gmail.com"};
        for(int i= 0; i < ages.length; i++){
            Fish fish = new Fish().withId(String.valueOf(i+1)).withAge(ages[i]);
            fishRepository.save(fish);
        }
    }

    /**
     * IMPLEM CRUD
     */
    public List<Fish> findAll(){
        List<Fish> foundFish = new ArrayList<>();
        fishRepository.findAll().forEach(foundFish::add);
        return foundFish;
    }

    public Fish findById(String id){
        Optional<Fish> fish =  fishRepository.findById(id);
        if(fish.isPresent()){
            return fish.get();
        }else{
            return null;
        }
    }

    public Fish addFish(Fish fish){
        return fishRepository.save(fish);
    }

    public Fish removeFish(String id){
        return fishRepository.deleteFishById(id);
    }

    public Fish updateFish(Fish fish){
        return fishRepository.save(fish);
    }


}
