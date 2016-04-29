package com.example.project.forrent;

import java.io.Serializable;

/**
 * Created by colliell on 4/13/2016.
 * Holds information for each property in the list
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
    private String date;
    private String phone;
    private String email;

    public Prop(String addr, String link, String rank, String rooms,
                String bathrooms, String price, String sqft, String pets,
                String date, String phone, String email) {
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

        if (date != null) this.date = date;
        else this.date = "Not listed";

        if (phone != null) this.phone = phone;
        else this.phone = "Not listed";

        if (email != null) this.email = email;
        else this.email = "Not listed";

    }

    public int rankToInt() {
        return Integer.parseInt(rank);
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

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
}
