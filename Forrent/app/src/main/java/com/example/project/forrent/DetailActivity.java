package com.example.project.forrent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anna on 4/25/16.
 */
public class DetailActivity extends AppCompatActivity {
    private List<Map<String, String>> data;
    private ListView listView2 = null;


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
        String date = getIntent().getStringExtra("date");
        String phone = getIntent().getStringExtra("phone");
        String email = getIntent().getStringExtra("email");
        Prop prop = new Prop(addr, link, rank, rooms, bathrooms
                , price, sqft, pets, date, phone, email);
        PrepareData(prop);
        listView2 = new ListView(this);

        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), data,
                R.layout.detail_layout, new String[]{"addr", "link", "price", "rank", "rooms"
                , "bathrooms", "sqft", "pets", "date", "phone", "email"},
                new int[]{R.id.Addr, R.id.Link, R.id.price, R.id.rank
                        , R.id.rooms, R.id.bathrooms, R.id.sqft, R.id.pets, R.id.date,
                        R.id.phone, R.id.email});
        listView2.setAdapter(adapter);
        setContentView(listView2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.example.project.forrent.R.menu.menu_delete, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.delete:
                String addr = getIntent().getStringExtra("addr");
                //Log.i("1", "addr = " + addr);
                Toast.makeText(this, "Deleted " + addr, Toast.LENGTH_SHORT).show();
                PropList propList = new PropList();
                if(Storage.fileExists(getApplicationContext(), "proplist.forrent")) {
                    //Log.w("testinglog", "get here!!!");
                    try {
                        PropList storedList = (PropList) Storage
                                .readObject(getApplication().getBaseContext(), "proplist.forrent");
                        //Log.i("1", "storedList = " + storedList.props.get(0).getAddr());
                        propList.deleteProp(storedList, addr);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Storage.writeObject(getApplicationContext(), "proplist.forrent", propList);
                    finish();
                    Intent intent = new Intent(getApplication()
                            .getBaseContext(), MainActivity.class);
                    startActivity(intent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
        }
        return (super.onOptionsItemSelected(item));
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
        hm.put("phone", prop.getPhone());
        hm.put("date", prop.getDate());
        hm.put("email", prop.getEmail());
        data.add(hm);
    }
}


