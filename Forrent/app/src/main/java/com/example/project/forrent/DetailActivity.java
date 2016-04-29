package com.example.project.forrent;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anna on 4/25/16.
 */
public class DetailActivity extends AppCompatActivity {
    private List<Map<String, String>> data;
    private ListView listView2 = null;
    private ListView listViewAFterEdit = null;
    final static int EDIT_ITEM_INTENT=1;
    Prop prop;
    List<Prop> props = new ArrayList<Prop>(Arrays.asList(new Prop[]{}));
    static final int List_Item = 1;
    private String TAG="1";

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
        prop = new Prop(addr, link, rank, rooms, bathrooms
                , price, sqft, pets);
        PrepareData(prop);

        listView2 = new ListView(this);
        String[] from={"addr", "link", "rank", "rooms", "bathrooms"
                , "price", "sqft", "pets"};
        int[] to = {R.id.Addr, R.id.Link, R.id.rank, R.id.price
                , R.id.sqft, R.id.rooms, R.id.bathrooms, R.id.pets};
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), data,
                R.layout.detail_layout, from, to);
        listView2.setAdapter(adapter);
        setContentView(listView2);
        //setContentView(R.layout.detail_layout);


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


    public void onClick(View v) {
        //validateSaveExit();

        Intent intent = new Intent(DetailActivity.this, EdititemActivity.class);

        intent.putExtra("addr", prop.getAddr());
        intent.putExtra("rank", prop.getRank());
        intent.putExtra("link", prop.getLink());
        intent.putExtra("rooms", prop.getRooms());
        intent.putExtra("bathrooms", prop.getBathrooms());
        intent.putExtra("price", prop.getPrice());
        intent.putExtra("sqft", prop.getSqft());
        intent.putExtra("pets", prop.getPets());
        startActivity(intent);
    }
    public void onClickgoback(View v) {
        validateReplaceExit();
    }

    static final int SAVE_EDIT_ITEM_INTENT = -1;
    private void validateReplaceExit() {
        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra("link", ((TextView) findViewById(R.id.Link)).getText().toString());
        intent.putExtra("addr", ((TextView) findViewById(R.id.Addr)).getText().toString());
        intent.putExtra("rank", ((TextView) findViewById(R.id.rank)).getText().toString());
        intent.putExtra("rooms", ((TextView) findViewById(R.id.rooms)).getText().toString());
        intent.putExtra("bathrooms", ((TextView) findViewById(R.id.bathrooms)).getText().toString());
        intent.putExtra("price", ((TextView) findViewById(R.id.price)).getText().toString());
        intent.putExtra("sqft", ((TextView) findViewById(R.id.sqft)).getText().toString());
        intent.putExtra("pets", ((TextView) findViewById(R.id.pets)).getText().toString());
        startActivity(intent);
        setResult(2, intent);
        //Log.i(TAG, "My position is validateSaveExit~~~~~~~~~~"+SAVE_EDIT_ITEM_INTENT);
        //finish();
    }
}


