package com.google.app.backend;

import com.google.appengine.repackaged.com.google.api.client.json.GenericJson;
import com.google.appengine.repackaged.com.google.api.client.util.Key;

/**
 * Created by Michael on 6/4/2016.
 */
@SuppressWarnings("javadoc")
public final class MyBean extends GenericJson {

    @Key
    private java.lang.String data;
    private java.lang.String id;
    private java.lang.String timestamp;
    private boolean error = true;


    public java.lang.String getData() {
        return data;
    }

    public MyBean setData(java.lang.String data) {
        this.data = data;
        return this;
    }

    public MyBean setId(java.lang.String id){
        this.data = id;
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