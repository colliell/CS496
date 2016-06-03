package com.example.project.forrent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import com.google.app.backend.myApi.MyApi;
import com.google.app.backend.myApi.model.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by colliell on 4/13/2016.
 * Holds information for each property in the list
 */
public class DataStore implements Serializable {

    private static MyApi myApiService = null;
    private static Context context;

    private static void setApiService(){
        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                .setRootUrl("https://forrent-1310.appspot.com/_ah/api/");
        myApiService = builder.build();
    }

    public static boolean createProp(Prop prop, Context cont) {
        if(myApiService == null) {
            setApiService();
        }
        context = cont;

        PropEntity response;
        try{
            response = myApiService.createProp(prop.getGroupID(), prop.getPassword(), prop.JsonMap()).execute();
        } catch(IOException e){
            showMessage(e.getMessage());
            return false;
        }

        if(response == null) {
            showMessage("Problem creating prop on server");
            return false;
        }
        prop.setId(response.getId());
        prop.setLastUpdatedTime(response.getTimestamp().toString());
        return true;

    }

    public static boolean updateProp(Prop prop, Context cont) {
        if(myApiService == null) {
            setApiService();
        }
        context = cont;
        PropEntity response ;
        try{
            response = myApiService.updateProp(prop.getGroupID(),prop.getPassword(),prop.getId(),Long.parseLong(prop.getLastUpdatedTime()),prop.JsonMap()).execute();
        } catch(IOException e) {
            showMessage(e.getMessage());
            return false;
        }
        if(response == null) {
            showMessage("Problem updating prop, make sure there aren't any new updates you're missing");
            return false;
        }
        prop.setLastUpdatedTime(response.getTimestamp().toString());
        return true;
    }

    public static boolean getProps(PropList list, Context cont) {
        if(myApiService == null) {
            setApiService();
        }
        context = cont;
        List<PropEntity> ents;
        try{
            ents = myApiService.getProps(list.getGroupID(), list.getPassword()).execute().getItems();
        } catch(IOException e){
            showMessage(e.getMessage());
            return false;
        }
        if (ents == null){
            showMessage("Could not retrieve props, ensure correct username and password");
            return false;
        }
        Prop prop;
        for (int i = 0; i < ents.size(); i++){
            list.updateProp(ents.get(i));
        }
        return true;
    }

    public static boolean deleteProp(Prop prop, Context cont) {
        if(myApiService == null) {
            setApiService();
        }
        context = cont;
        Response response;
        try{
            response = myApiService.deleteProp(prop.getGroupID(), prop.getPassword(), prop.getId()).execute();
        } catch(IOException e){
            showMessage(e.getMessage());
            return false;
        }
        showMessage(response.getMessage());
        return true;
    }

    public static boolean createGroup(String id, String password, Context cont) {
        if(myApiService == null) {
            setApiService();
        }
        context = cont;
        Response response;
        try{
            response = myApiService.createGroup(id, password).execute();
        } catch(IOException e){
            showMessage(e.getMessage());
            return false;
        }
        showMessage(response.getMessage());
        return true;
    }

    public static Map<String, Integer> getStats(){
        if(myApiService == null) {
            setApiService();
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("Statistic 1", 123);
        map.put("Statistic 2", 324);
        map.put("Statistic 3", 48593);
        return map;
    }



    private static void showMessage(String e){
        Toast.makeText(context, e, Toast.LENGTH_LONG).show();
    }

}
