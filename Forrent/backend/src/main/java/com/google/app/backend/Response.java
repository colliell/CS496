package com.google.app.backend;

import com.google.appengine.repackaged.com.google.api.client.json.GenericJson;

import java.io.Serializable;

/** The object model for the data we are sending through endpoints */
@SuppressWarnings("javadoc")
public class Response extends GenericJson {

    String message;
    boolean error;

    public Response(String message, boolean error){
        this.message = message;
        this.error = error;
    }
}