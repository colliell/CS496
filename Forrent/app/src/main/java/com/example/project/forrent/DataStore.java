package com.example.project.forrent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.app.backend.myApi.MyApi;
import com.google.app.backend.myApi.model.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
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
                .setRootUrl("https://forrent-1310.appspot.com/_ah/api/")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }

                });

        myApiService = builder.build();
    }

    public static boolean createProp(Prop prop, Context cont) throws IOException {
        if(myApiService == null) {
            setApiService();
        }
        context = cont;

        JsonMap response;
        Log.i("DataStore", "prop.groupID = " + prop.getGroupID());

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
        String id = (String) response.get("id");

        Log.i("DataStore1", response.toPrettyString());
        Log.i("DataStore1", "id = " + id);

        prop.setId(Long.valueOf(id));
        prop.setLastUpdatedTime(System.currentTimeMillis());

        return true;
    }

    public static boolean updateProp(Prop prop, Context cont) {
        if(myApiService == null) {
            setApiService();
        }
        context = cont;
        PropEntity response ;
        try{
            response = myApiService.updateProp(prop.getGroupID(),prop.getPassword(),prop.getId(),System.currentTimeMillis(),prop.JsonMap()).execute();
        } catch(IOException e) {
            showMessage(e.getMessage());
            return false;
        }
        if(response == null) {
            showMessage("Problem updating prop, make sure there aren't any new updates you're missing");
            return false;
        }
        prop.setLastUpdatedTime(response.getTimestamp());
        return true;
    }

    public static boolean getProps(PropList list, Context cont) {
        if(myApiService == null) {
            setApiService();
        }
        context = cont;
        JSONArray response = null;
        try{
            response = new JSONArray(myApiService.getProps(list.getGroupID(), list.getPassword()).execute().getItems().toString());
        } catch(IOException e){
            showMessage(e.getMessage());
            return false;
        } catch (JSONException e) {
            showMessage(e.getMessage());
            return false;
        }
        if (response == null){
            showMessage("Could not retrieve props, ensure correct username and password");
            return false;
        }
        Prop prop;

        for (int i = 0; i < response.length(); i++){
            try {
                list.updateProp((JSONObject)response.get(i));
            } catch (JSONException e) {
                showMessage("screwed up in looping through responses");
                return false;
            }
        }
        return true;
    }

    public static boolean deleteProp(Prop prop, Context cont) {
        if(myApiService == null) {
            setApiService();
        }
        context = cont;
        JsonMap response;
        Log.i("DataSTore2", "prop.getID = " + prop.getId() + " + groupid = " + prop.getGroupID());
        try{
            response = myApiService.deleteProp(prop.getGroupID(), prop.getPassword(), prop.getId()).execute();
        } catch(IOException e){
            showMessage(e.getMessage());
            return false;
        }
        showMessage(response.get("data").toString());
        return true;
    }

    public static boolean createGroup(String id, String password, Context cont) {
        if(myApiService == null) {
            setApiService();
        }
        context = cont;
        JsonMap response;
        try{
            response = myApiService.createGroup(id, password).execute();
        } catch(IOException e){
            showMessage(e.getMessage());
            return false;
        }
        showMessage(response.get("data").toString());
        return true;
    }

    public static Map<String, Integer> getStats(String propGroupID, String propPassword){
        int numProps = 0;
        int avePrice = 0;
        if(myApiService == null) {
            setApiService();
        }
        Map<String, Integer> map = new HashMap<>();
        String string;
        List<String> stats;
        try{
            string = (String)myApiService.getStats().execute().get("data");
            stats = Arrays.asList(string.split(","));
        } catch(IOException e){
            showMessage(e.getMessage());
            return null;
        }
        /*
        avePrice = getAvargePrice(propGroupID, propPassword);
        try{
            numProps = myApiService.getProps(propGroupID, propPassword).execute().size();}
        catch(IOException e){
            showMessage(e.getMessage());
        }
        */
        map.put("props", new Integer(stats.get(0)));
        map.put("price", new Integer(stats.get(1)));
        map.put("sqft", new Integer(stats.get(2)));
        map.put("rooms", new Integer(stats.get(3)));
        map.put("bathrooms", new Integer(stats.get(4)));
        return map;
    }

    private static void showMessage(String e){
        Toast.makeText(context, e, Toast.LENGTH_LONG).show();
    }

    public static int getAvargePrice(String propGroupID, String propPassword){
        int avePrice = 0;
        int numProps = 0;
        int totPrice = 0;
        if(myApiService == null) {
            setApiService();
        }
        List<PropEntity> entss;
        try{
            numProps = myApiService.getProps(propGroupID, propPassword).size();
            entss = myApiService.getProps(propGroupID, propPassword).execute().getItems();
        }
        catch(IOException e){
            showMessage(e.getMessage());
            return avePrice;}
        if (entss == null){
            showMessage("Could not retrieve props, ensure correct username and password");
            return avePrice;
        }
        for (int i = 0; i < numProps ; i++){
            totPrice = totPrice + Integer.parseInt(entss.get(i).getPrice());
        }
        avePrice = totPrice/numProps;
        return avePrice;
    }
}
