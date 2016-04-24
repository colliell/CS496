package com.example.project.forrent;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

public class PropList extends ListFragment implements Serializable {
    int[] logos = new int[]{
            com.example.project.forrent.R.drawable.purple,
            com.example.project.forrent.R.drawable.orange,
            com.example.project.forrent.R.drawable.green,
            com.example.project.forrent.R.drawable.blue
    };

    List<Prop> props = new ArrayList<Prop>(Arrays.asList(new Prop[]{}));

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setupList();

        return super.onCreateView(inflater, container, savedInstanceState);
    }

//    public int getPropAtRank(int rank) {
//        for (int i = 0; i < props.size(); i++) {
//            if (props.getRank() == rank) {
//                return i;
//              }
//        }
//    }

    private void setupList() {
        List<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < props.size(); i++) {
            //Prop prop = props.get(getPropAtRank(i));
            Prop prop = props.get(i);
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("addr", prop.getAddr());
            hm.put("link", prop.getLink());
            hm.put("logo", Integer.toString(logos[i % logos.length]));
            rows.add(hm);
        }
        String[] from = {"logo", "addr", "link"};
        int[] to = {com.example.project.forrent.R.id.logo, com.example.project.forrent.R.id.addr, com.example.project.forrent.R.id.link};

        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), rows, com.example.project.forrent.R.layout.listview_layout, from, to);
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
}