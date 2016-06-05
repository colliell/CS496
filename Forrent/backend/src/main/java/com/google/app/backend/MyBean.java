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
    private boolean error = true;


    public java.lang.String getData() {
        return data;
    }

    public MyBean setData(java.lang.String data) {
        this.data = data;
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