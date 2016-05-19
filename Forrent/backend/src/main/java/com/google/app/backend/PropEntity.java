package com.google.app.backend;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.Map;

/**
 * Created by Michael on 5/18/2016.
 */

@Entity
public class PropEntity {
    @Id String id;

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

    public PropEntity(String addr, String link, String rank, String rooms,
                String bathrooms, String price, String sqft, String pets,
                String date, String phone, String email, String groupName, String groupPass) {
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

        this.id = groupName + "-" + encryptPass(groupPass);
    }

    public PropEntity(String groupName, String groupPass, Map<String, String> attr){
        this.attributes = attributes;
        this.id = groupName + "-" + encryptPass(groupPass);

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
    }

    public static String encryptPass(String pass){
        return pass;
    }
}
