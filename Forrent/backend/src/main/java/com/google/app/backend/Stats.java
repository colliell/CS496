package com.google.app.backend;

import com.google.appengine.repackaged.com.google.common.base.Flag;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by Michael on 6/7/2016.
 */

@Entity
public class Stats {
    @Id
    Long id;

    private Integer propCount;
    private Integer avgPrice;
    private Integer avgSqft;
    private Integer avgRooms;
    private Integer avgBathrooms;

    public Stats(){
        id = 1L;
        propCount = 0;
        avgPrice = 0;
        avgSqft = 0;
        avgBathrooms = 0;
        avgRooms = 0;
    }

    public Integer getPropCount() {
        return propCount;
    }

    public void setPropCount(Integer propCount) {
        this.propCount = propCount;
    }

    public Integer getAvgSqft() {
        return avgSqft;
    }

    public void setAvgSqft(Integer avgSqft) {
        this.avgSqft = avgSqft;
    }

    public Integer getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Integer avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Integer getAvgRooms() {
        return avgRooms;
    }

    public void setAvgRooms(Integer avgRooms) {
        this.avgRooms = avgRooms;
    }

    public Integer getAvgBathrooms() {
        return avgBathrooms;
    }

    public void setAvgBathrooms(Integer avgBathrooms) {
        this.avgBathrooms = avgBathrooms;
    }
}
