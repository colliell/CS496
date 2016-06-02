package com.google.app.backend;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.Map;

/**
 * Created by Michael on 5/18/2016.
 */

@Entity
public class PropEntity {
    @Id Long id = null;
    @Index String groupName;

    Map<String, String> attributes;

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

    private Long timestamp;

    public String getAddr() {
        return addr;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PropEntity(String addr, String link, String rank, String rooms,
                      String bathrooms, String price, String sqft, String pets,
                      String date, String phone, String email) {
        this.addr = addr;
        this.link = link;
        this.rank = rank;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.price = price;
        this.sqft = sqft;
        this.pets = pets;
        this.date = date;
        this.phone = phone;
        this.email = email;

        setTimestamp();
    }

    public PropEntity(String groupName, Map<String, String> attr){
        this.groupName = groupName;

        this.attributes = attr;

        this.addr = attr.get("addr");
        this.link = attr.get("link");
        this.rank = attr.get("rank");
        this.rooms = attr.get("rooms");
        this.bathrooms = attr.get("bathrooms");
        this.price = attr.get("price");
        this.sqft = attr.get("sqft");
        this.pets = attr.get("pets");
        this.date = attr.get("date");
        this.phone = attr.get("phone");
        this.email = attr.get("email");

        setTimestamp();
    }

    public void setTimestamp(){
        this.timestamp = System.currentTimeMillis();
    }

    public Long getTimestamp(){
        return timestamp;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId() { return id; }


    public static String encryptPass(String pass){
        return pass;
    }
}
