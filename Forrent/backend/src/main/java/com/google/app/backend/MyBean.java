package com.google.app.backend;

import com.google.api.server.spi.config.ApiResourceProperty;
import com.google.appengine.repackaged.com.google.api.client.json.GenericJson;
import com.google.appengine.repackaged.com.google.api.client.util.Key;

/**
 * Created by Michael on 6/4/2016.
 */
@SuppressWarnings("javadoc")
public final class MyBean extends GenericJson {

    @Key
    private java.lang.String data;

    @Key
    private java.lang.String id;

    @Key
    private java.lang.String timestamp;

    @Key
    private boolean error = false;


    public java.lang.String getData() {
        return data;
    }

    public java.lang.String getId() {return id; }

    public java.lang.String getTimestamp() { return timestamp; }

    public MyBean setData(java.lang.String data) {
        this.data = data + ".";
        return this;
    }

    public MyBean setId(java.lang.String id){
        this.id = id;
        return this;
    }

    public MyBean setTimestamp(String timestamp){
        this.timestamp = timestamp;
        return this;
    }

    @Override
    public MyBean set(String fieldName, Object value) {
        return (MyBean) super.set(fieldName, value);
    }

    @Override
    public MyBean clone() {
        return (MyBean) super.clone();
    }

}