package com.example.project.forrent;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.google.app.backend.myApi.model.JsonMap;
import com.google.app.backend.myApi.model.PropEntity;

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
    private String lastUpdatedTime;
    private String groupID;
    private String password;
    private Long id;

    public Prop(String addr, String link, String rank, String rooms,
                String bathrooms, String price, String sqft, String pets,
                String date, String phone, String email,String lastUpdatedTime,
                String groupID, String password) {
        this.addr = addr;
        this.link = link;
        this.rank = rank;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.price = price;
        this.lastUpdatedTime = lastUpdatedTime;
        this.groupID = groupID;
        this.password = password;

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

    public Prop(PropEntity entity, String groupID, String password){
        this.addr = entity.getAddr();
        this.link = entity.getLink();
        this.rank = entity.getRank();
        this.rooms = entity.getRooms();
        this.bathrooms = entity.getBathrooms();
        this.price = entity.getPrice();
        this.sqft = entity.getSqft();
        this.pets = entity.getPets();
        this.date = entity.getDate();
        this.phone = this.getPhone();
        this.email = this.getEmail();

        this.lastUpdatedTime = entity.getTimestamp().toString();
        this.groupID = groupID;
        this.password = password;
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

    public String getLastUpdatedTime() { return lastUpdatedTime; }

    public void setLastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }
    public String getGroupID() {return groupID;}

    public void setGroupID(String groupID) {this.groupID = groupID;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Intent callPhone() {
        if(this.phone != "Not listed" && this.phone != null){
            //ACTION_DIAL should pull up dial pad rather than start calling, works on emulator
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
            phoneIntent.setData(Uri.parse("tel:" + this.phone));
            return phoneIntent;
        }
        return null;
    }

    public Intent sendEmail() {
        if(this.email != "Not listed" && this.email != null){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:" + this.email));

            return emailIntent;
        }
        return null;
    }
    
    public JsonMap JsonMap(){
        JsonMap map = new JsonMap();

        map.set("addr", this.getAddr());
        map.set("link", this.getLink());
        map.set("rank", this.getRank());
        map.set("rooms", this.getRooms());
        map.set("bathrooms", this.getBathrooms());
        map.set("price", this.getPrice());
        map.set("sqft", this.getSqft());
        map.set("pets", this.getPets());
        map.set("date", this.getDate());
        map.set("phone", this.getPhone());
        map.set("email", this.getEmail());

        return map;
    }
}
