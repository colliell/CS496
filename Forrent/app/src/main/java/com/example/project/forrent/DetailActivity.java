package com.example.project.forrent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anna on 4/25/16.
 */
public class DetailActivity extends Activity {
    private List<Map<String, String>> data;
    private ListView listView2 = null;
    List<Prop> props = new ArrayList<Prop>(Arrays.asList(new Prop[]{}));
    static final int List_Item = 1;

    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        String addr = getIntent().getStringExtra("addr");
        String link = getIntent().getStringExtra("link");
        String rank = getIntent().getStringExtra("rank");
        String rooms = getIntent().getStringExtra("rooms");
        String bathrooms = getIntent().getStringExtra("bathrooms");
        String price = getIntent().getStringExtra("price");
        String sqft = getIntent().getStringExtra("sqft");
        String pets = getIntent().getStringExtra("pets");
        Prop prop = new Prop(addr, link, rank, rooms, bathrooms
                , price, sqft, pets);
        PrepareData(prop);
        listView2 = new ListView(this);


        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), data,
                R.layout.detail_layout, new String[]{"addr", "link", "rank", "rooms", "bathrooms"
                , "price", "sqft", "pets"},
                new int[]{R.id.Addr, R.id.Link, R.id.rank, R.id.price
                        , R.id.sqft, R.id.rooms, R.id.bathrooms, R.id.pets});
        listView2.setAdapter(adapter);
        setContentView(listView2);
    }

    private void PrepareData(Prop prop) {
        data = new ArrayList<Map<String, String>>();
        Map<String, String> hm;
        hm = new HashMap<String, String>();
        hm.put("addr", prop.getAddr());
        hm.put("link", prop.getLink());
        hm.put("price", prop.getPrice());
        hm.put("rooms", prop.getRooms());
        hm.put("bathrooms", prop.getBathrooms());
        hm.put("sqft", prop.getSqft());
        hm.put("pets", prop.getPets());
        hm.put("rank", prop.getRank());
        data.add(hm);
    }


}


