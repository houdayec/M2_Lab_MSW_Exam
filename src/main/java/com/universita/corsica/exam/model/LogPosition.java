package com.universita.corsica.exam.model;

import org.joda.time.DateTime;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Class that describes a position log for a fish
 */

@Document(indexName = "positions", type="position")
public class LogPosition {

    /**
     * INTERN STATE
     */
    @NotNull
    public String idFish;
    @NotNull
    public GeoPoint position;
    @NotNull
    public DateTime date;

    /**
     * DEFAULT CONSTRUCTOR
     */
    public LogPosition() {
    }

    /**
     * GETTERS AND SETTERS
     */
    public String getIdFish() {
        return idFish;
    }

    public void setIdFish(String idFish) {
        this.idFish = idFish;
    }

    public GeoPoint getPosition() {
        return position;
    }

    public void setPosition(GeoPoint position) {
        this.position = position;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    /**
     * FLUENT API
     */
    public LogPosition withIdFish(String id){
        this.idFish = id;
        return this;
    }

    public LogPosition withPosition(GeoPoint position){
        this.position = position;
        return this;
    }

    public LogPosition withDate(DateTime date){
        this.date = date;
        return this;
    }

    /**
     * OVERRIDED METHODS
     */
    @Override
    public String toString() {
        return "LogPosition{" +
                "idFish='" + idFish + '\'' +
                ", position=" + position +
                ", date=" + date +
                '}';
    }
}
