package com.example.project.forrent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * Created by colliell on 4/13/2016.
 * Holds information about a list of properties for displaying
 */
public class PropList extends ListFragment implements Serializable {

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

    public void addProp(Prop prop) {
        props.add(prop);
        setupList();
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
}