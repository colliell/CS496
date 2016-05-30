package com.google.app.backend;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by Michael on 5/29/2016.
 */
@Entity
public class GroupEntity {
    @Id
    String name;

    String password;

    public GroupEntity(String name, String password){
        this.name = name;
        this.password = password;
    }
}