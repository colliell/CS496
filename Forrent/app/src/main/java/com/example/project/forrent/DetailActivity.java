package com.example.project.forrent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anna on 4/25/16.
 * Display the detail information of the clicked item
 */
public class DetailActivity extends AppCompatActivity {
    private List<Map<String, String>> data;
    private ListView listView2 = null;
    Prop prop;

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
        Long lastUpdatedTime = System.currentTimeMillis();
        String groupID = getIntent().getStringExtra("groupID");
        String password = getIntent().getStringExtra("password");

        prop = new Prop(addr, link, rank, rooms, bathrooms
                , price, sqft, pets, date, phone, email,lastUpdatedTime,groupID,password);
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
        getMenuInflater().inflate(com.example.project.forrent.R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        Intent intent;
        switch (item.getItemId()) {
            case R.id.delete:
                String addr = getIntent().getStringExtra("addr");
                //Log.i("1", "addr = " + addr);
                Toast.makeText(this, "Deleted " + addr, Toast.LENGTH_SHORT).show();
                PropList storedList = new PropList();
                PropList propList = new PropList();
                if(Storage.fileExists(getApplicationContext(), "proplist.forrent")) {
                    //Log.w("testinglog", "get here!!!");
                    try {
                        propList = (PropList) Storage
                                .readObject(getApplication().getBaseContext(), "proplist.forrent");
                        DataStore.deleteProp(propList.props.get(propList.getProp(prop.getAddr())), getApplicationContext());
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
                    intent = new Intent(getApplication()
                            .getBaseContext(), ViewListActivity.class);
                    intent.putExtra("groupID", storedList.getGroupID());
                    intent.putExtra("password", storedList.getPassword());
                    //Log.i("afterDelete", "storedlist groupID = " + storedList.getGroupID());
                    startActivity(intent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            case R.id.map:
                //Log.i("1", "map_button");
                Intent mapIntent = new Intent(this, MapActivity.class);
                mapIntent.putExtra("addr", getIntent().getStringExtra("addr"));
                startActivity(mapIntent);
                return true;
            case R.id.web:
                Intent webIntent = new Intent(this, WebViewActivity.class);
                webIntent.putExtra("link", getIntent().getStringExtra("link"));
                startActivity(webIntent);
                return true;
            case R.id.call:
                intent = prop.callPhone();
                if(intent != null){
                    startActivity(intent);
                    return true;
                } else {
                    return false;
                }
            case R.id.email:
                intent = prop.sendEmail();
                if(intent != null) {
                    startActivity(Intent.createChooser(intent, "Send Email with..."));
                    return true;
                } else {
                    return false;
                }
            case R.id.edit:
                intent = new Intent(DetailActivity.this, EditItemActivity.class);

                intent.putExtra("addr", prop.getAddr());
                intent.putExtra("rank", prop.getRank());
                intent.putExtra("link", prop.getLink());
                intent.putExtra("rooms", prop.getRooms());
                intent.putExtra("bathrooms", prop.getBathrooms());
                intent.putExtra("price", prop.getPrice());
                intent.putExtra("sqft", prop.getSqft());
                intent.putExtra("pets", prop.getPets());
                intent.putExtra("date", prop.getDate());
                intent.putExtra("phone", prop.getPhone());
                intent.putExtra("email", prop.getEmail());
                intent.putExtra("lastUpdatedTime", prop.getLastUpdatedTime());
                intent.putExtra("groupID", prop.getGroupID());
                intent.putExtra("password", prop.getPassword());
                startActivity(intent);
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
    public void onClick(View v) {
        Intent intent = new Intent(DetailActivity.this, EditItemActivity.class);

        intent.putExtra("addr", prop.getAddr());
        intent.putExtra("rank", prop.getRank());
        intent.putExtra("link", prop.getLink());
        intent.putExtra("rooms", prop.getRooms());
        intent.putExtra("bathrooms", prop.getBathrooms());
        intent.putExtra("price", prop.getPrice());
        intent.putExtra("sqft", prop.getSqft());
        intent.putExtra("pets", prop.getPets());
        intent.putExtra("date", prop.getDate());
        intent.putExtra("phone", prop.getPhone());
        intent.putExtra("email", prop.getEmail());
        intent.putExtra("lastUpdatedTime", prop.getLastUpdatedTime());
        intent.putExtra("groupID", prop.getGroupID());
        intent.putExtra("password", prop.getPassword());
        startActivity(intent);
    }

}


