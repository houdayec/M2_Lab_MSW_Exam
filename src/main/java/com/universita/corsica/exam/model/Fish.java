package com.universita.corsica.exam.model;

import com.universita.corsica.exam.enums.KindFish;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import javax.validation.constraints.NotNull;

/**
 * Class that describes a fish
 */
@Document(indexName = "fish", type="fish")
public class Fish {

    /**
     * INTERN STATE
     */
    @NotNull
    @Id
    public String id;
    public KindFish kindFish;
    public int ageInMonths;
    public GeoPoint position;
    public boolean protectedFish;

    /**
     * DEFAULT CONSTRUCTOR
     */
    public Fish() {
    }

    /**
     * GETTERS AND SETTERS
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public KindFish getKindFish() {
        return kindFish;
    }

    public void setKindFish(KindFish kindFish) {
        this.kindFish = kindFish;
    }

    public int getAgeInMonths() {
        return ageInMonths;
    }

    public void setAgeInMonths(int ageInMonths) {
        this.ageInMonths = ageInMonths;
    }

    public GeoPoint getPosition() {
        return position;
    }

    public void setPosition(GeoPoint position) {
        this.position = position;
    }

    public boolean isProtectedFish() {
        return protectedFish;
    }

    public void setProtectedFish(boolean protectedFish) {
        this.protectedFish = protectedFish;
    }

    /**
     * FLUENT API
     */
    public Fish withId(String id){
        this.id = id;
        return this;
    }

    public Fish withKind(KindFish kindFish){
        this.kindFish = kindFish;
        return this;
    }

    public Fish withAge(int ageInMonths){
        this.ageInMonths = ageInMonths;
        return this;
    }

    public Fish withPosition(GeoPoint position){
        this.position = position;
        return this;
    }

    public Fish isProtected(boolean isProtected){
        this.protectedFish = isProtected;
        return this;
    }

    /**
     * OVERRIDED METHODS
     */
    @Override
    public String toString() {
        return "Fish{" +
                "id='" + id + '\'' +
                ", kindFish=" + kindFish +
                ", ageInMonths=" + ageInMonths +
                ", position=" + position +
                ", protectedFish=" + protectedFish +
                '}';
    }
}
