package com.google.app.backend;

/** The object model for the data we are sending through endpoints */
public class Response {

    private String message;
    private boolean error;

    public Response(String message, boolean error){
        this.message = message;
        this.error = error;
    }

    public String message() {
        return message;
    }

    public boolean error(){
        return error;
    }

    public void setMessage(String data) {
        message = data;
    }
    public void hasError(){error = true;}
    public void noError(){error = false;}
}