package com.example.project.forrent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by blueblood on 4/27/16.
 */
public class EdititemActivity extends AppCompatActivity {
    private ListView listView = null;
    private List<Map<String, String>> data;
    private static final String TAG = "1";
    private Prop propEdit;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        String addr = getIntent().getStringExtra("addr");
        String link = getIntent().getStringExtra("link");
        String rank = getIntent().getStringExtra("rank");
        String rooms = getIntent().getStringExtra("rooms");
        String bathrooms = getIntent().getStringExtra("bathrooms");
        String price = getIntent().getStringExtra("price");
        String sqft = getIntent().getStringExtra("sqft");
        String pets = getIntent().getStringExtra("pets");

        propEdit = new Prop(addr, link, rank, rooms, bathrooms
                , price, sqft, pets);
        PrepareData(propEdit);


        String[] from={"addr", "link", "rank", "rooms", "bathrooms"
                , "price", "sqft", "pets"};
        int[] to = {R.id.editAddr, R.id.editLink, R.id.editrank, R.id.editrooms
                , R.id.editbathrooms, R.id.editprice, R.id.editsqft, R.id.editpets};
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), data,
                R.layout.edit_item_layout, from, to);
        listView = new ListView(this);
        listView.setAdapter(adapter);
        setContentView(listView);
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
        EditText addr = (EditText)findViewById(R.id.editAddr);
        EditText link = (EditText)findViewById(R.id.editLink);
        EditText rank = (EditText)findViewById(R.id.editrank);
        EditText rooms = (EditText)findViewById(R.id.editrooms);
        EditText bathrooms = (EditText)findViewById(R.id.editbathrooms);
        EditText price = (EditText)findViewById(R.id.editprice);
        EditText sqrt = (EditText)findViewById(R.id.editsqft);
        EditText pets = (EditText)findViewById(R.id.editpets);

        //Log.i(TAG, "My after edit item addr is ~~~~~~~~~~" + addr.getText().toString());
        Intent intent = new Intent(EdititemActivity.this, DetailActivity.class);
        intent.putExtra("link", addr.getText().toString());
        intent.putExtra("addr", link.getText().toString());
        intent.putExtra("rank", rank.getText().toString());
        intent.putExtra("rooms", rooms.getText().toString());
        intent.putExtra("bathrooms", bathrooms.getText().toString());
        intent.putExtra("price", price.getText().toString());
        intent.putExtra("sqft", sqrt.getText().toString());
        intent.putExtra("pets",pets.getText().toString());
        startActivity(intent);
        finish();
    }
}
