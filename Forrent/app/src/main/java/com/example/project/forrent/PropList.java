package com.example.project.forrent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.app.backend.myApi.model.PropEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by colliell on 4/13/2016.
 * Holds information about a list of properties for displaying
 */

public class PropList extends ListFragment implements Serializable {
//need set and get groupID and password
    private String groupID;
    private String password;
    private Date lastUpdatedTime;

    int[] logos = new int[]{
            com.example.project.forrent.R.drawable.purple,
            com.example.project.forrent.R.drawable.orange,
            com.example.project.forrent.R.drawable.green,
            com.example.project.forrent.R.drawable.blue
    };

    List<Prop> props = new ArrayList<Prop>(Arrays.asList(new Prop[]{}));

    @Override
    public View onCreateView
            (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setupList();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void sortPropByRank() {
        Collections.sort(props, new Comparator<Prop>() {
            public int compare(Prop p1, Prop p2) {
                return p1.rankToInt() - p2.rankToInt();
            }
        });
    }

    //these two methods might be useful later
    public boolean isEmtpy() {
        return props.size() == 0;
    }

    public int getSize() {
        return props.size();
    }

    private void setupList() {
        List<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
        sortPropByRank();
        for (int i = 0; i < props.size(); i++) {
            Prop prop = props.get(i);
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("addr", prop.getAddr());
            hm.put("link", prop.getLink());
            hm.put("logo", Integer.toString(logos[i % logos.length]));
            rows.add(hm);
        }
        String[] from = {"logo", "addr", "link"};
        int[] to = {com.example.project.forrent.R.id.logo
                , com.example.project.forrent.R.id.addr
                , com.example.project.forrent.R.id.link};
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(),
                rows, com.example.project.forrent.R.layout.listview_layout, from, to);
        setListAdapter(adapter);
    }

    public void merge(PropList otherList) {
        props.addAll(otherList.props);
        setupList();
    }
    public void mergeEditProp(PropList otherList) {
        props.addAll(otherList.props);

    }

    public void addProp(Prop prop) {
        props.add(prop);
        setupList();
    }
    public void addEditProp(Prop prop) {
        //props.addAll(otherList.props);
        props.add(prop);
    }

    public Prop getProp(PropList otherList, String addr) {
        props.addAll(otherList.props);
        for (int i = 0; i < props.size(); i++) {
            if(props.get(i) != null) {
                Prop prop = props.get(i);
                if (prop.getAddr().equals(addr))
                    return prop;
            }
        }
        return null;
    }

    public void deleteProp(PropList otherList, String addr) {
        props.addAll(otherList.props);
        for (int i = 0; i < props.size(); i++) {
            if(props.get(i) != null) {
                Prop prop = props.get(i);
                if (prop.getAddr().equals(addr))
                    props.remove(prop);
            }
        }
    }

    public String getGroupID() {return groupID;}

    public void setGroupID(String groupID) {this.groupID = groupID;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public boolean isGroupIDSet(){
        if (getGroupID()==null){
            return false;}
        else { return  true;}
    }

    public Prop getProp(Long id){
        for(int i = 0; i < this.props.size(); i++){
            if (props.get(i).getId() == id){
                return props.get(i);
            }
        }
        return null;
    }

    public void updateProp(JSONObject entity){
        for(int i = 0; i< this.props.size(); i++){
            try {
                Log.i("update prop", "ID = " + (String)entity.get("id"));
                if(props.get(i).getId() == Long.parseLong((String)entity.get("id"),10)){
                    props.add(i, new Prop(entity, groupID, password));
                    return;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        props.add(new Prop(entity, groupID, password));
    }
}