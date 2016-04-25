package com.example.project.forrent;

import java.io.Serializable;

/**
 * Created by sehci on 4/4/2016.
 * Modified by colliell on 4/13/2016.
 */
public class Prop implements Serializable {
    private String addr;
    private String link;
    private String rank;
    private String rooms;
    private String bathrooms;
    private String price;
    private String sqft;
    private String pets;

    public Prop(String addr, String link, String rank, String rooms,
                String bathrooms, String price, String sqft, String pets) {
        this.addr = addr;
        this.link = link;
        this.rank = rank;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.price = price;

        if (sqft != null) this.sqft = sqft;
        else this.sqft = "Not listed";

        if (pets != null) this.pets = pets;
        else this.pets = "Not listed";
    }

    public String getAddr() { return addr; }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(String bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSqft() {
        return sqft;
    }

    public void setSqft(String sqft) {
        this.sqft = sqft;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }
}
