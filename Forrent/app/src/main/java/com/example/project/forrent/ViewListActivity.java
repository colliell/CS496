package com.example.project.forrent;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Reilly on 5/31/2016.
 * Activity for viewing proplist.
 */
public class ViewListActivity extends AppCompatActivity {
    private String propGroupID;
    private String propPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.project.forrent.R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        final PropList propList =
                (PropList) getSupportFragmentManager().findFragmentById
                        (com.example.project.forrent.R.id.proplist_fragment);
        if (getIntent().getStringExtra("joinGroup") != null) {
            propList.setGroupID(getIntent().getStringExtra("groupID"));
            propList.setPassword(getIntent().getStringExtra("password"));
            propGroupID = propList.getGroupID();
            propPassword = propList.getPassword();
            DataStore.getProps(propList, getApplicationContext());
            Log.i("viewList", "propList = " + propList.getGroupID());
            Log.i("viewList", "props size = " + propList.props.size());
            try {
                Storage.writeObject
                        (getApplicationContext(), "proplist.forrent", propList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (getIntent().getStringExtra("groupID") != null) {
            propList.setGroupID(getIntent().getStringExtra("groupID"));
            propList.setPassword(getIntent().getStringExtra("password"));
            propGroupID = propList.getGroupID();
            propPassword = propList.getPassword();
            try {
                Storage.writeObject(getApplicationContext(), "proplist.forrent", propList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (Storage.fileExists(getApplicationContext(), "proplist.forrent")) {
            try {
                Log.i("viewList2", "here");
                PropList storedList = (PropList) Storage
                        .readObject(getApplicationContext(), "proplist.forrent");
                propList.merge(storedList);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String addr = propList.props.get(position).getAddr();
                String link = propList.props.get(position).getLink();
                String rank = propList.props.get(position).getRank();
                String rooms = propList.props.get(position).getRooms();
                String bathrooms = propList.props.get(position).getBathrooms();
                String price = propList.props.get(position).getPrice();
                String sqft = propList.props.get(position).getSqft();
                String pets = propList.props.get(position).getPets();
                String date = propList.props.get(position).getDate();
                String phone = propList.props.get(position).getPhone();
                String email = propList.props.get(position).getEmail();
                Long lastUpdatedTime = Long.valueOf(propList.props.get(position).getLastUpdatedTime());
                String groupID = propList.getGroupID();
                String password = propList.getPassword();

                Intent intent2 = new Intent(ViewListActivity.this, DetailActivity.class);
                intent2.putExtra("link", link);
                intent2.putExtra("addr", addr);
                intent2.putExtra("rank", rank);
                intent2.putExtra("rooms", rooms);
                intent2.putExtra("bathrooms", bathrooms);
                intent2.putExtra("price", price);
                intent2.putExtra("sqft", sqft);
                intent2.putExtra("pets", pets);
                intent2.putExtra("date", date);
                intent2.putExtra("phone", phone);
                intent2.putExtra("email", email);
                intent2.putExtra("lastUpdatedTime", lastUpdatedTime.toString());
                intent2.putExtra("groupID", groupID);
                intent2.putExtra("password", password);

                startActivity(intent2);
            }
        };
        propList.getListView().setOnItemClickListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.example.project.forrent.R.menu.menu_main, menu);
        return true;
    }

    final static int ADD_ITEM_INTENT = 1; // use to signify result of adding item

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case com.example.project.forrent.R.id.add:
                Intent addItemIntent = new Intent(this, AddItemActivity.class);
                addItemIntent.putExtra("groupID", propGroupID);
                addItemIntent.putExtra("password", propPassword);
                startActivityForResult(addItemIntent, ADD_ITEM_INTENT);
                return (true);
            case R.id.stats:
                PropList propList =
                        (PropList) getSupportFragmentManager().findFragmentById
                                (com.example.project.forrent.R.id.proplist_fragment);
                Intent statsIntent = new Intent(this, StatsActivity.class);
                statsIntent.putExtra("groupID", propList.getGroupID());
                statsIntent.putExtra("password", propList.getPassword());
                startActivity(statsIntent);
                return (true);
            case com.example.project.forrent.R.id.changeGroup:
                Intent newUserIntent = new Intent(this, NewUserActivity.class);
                startActivity(newUserIntent);
                return (true);
            // BTW, you could handle other menu items here, if your menu had them
        }
        return (super.onOptionsItemSelected(item));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent returnIntent) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case ADD_ITEM_INTENT:
                    String addr = returnIntent.getStringExtra("addr");
                    String link = returnIntent.getStringExtra("link");
                    String rank = returnIntent.getStringExtra("rank");
                    String rooms = returnIntent.getStringExtra("rooms");
                    String bathrooms = returnIntent.getStringExtra("bathrooms");
                    String price = returnIntent.getStringExtra("price");
                    String sqft = returnIntent.getStringExtra("sqft");
                    String pets = returnIntent.getStringExtra("pets");
                    String date = returnIntent.getStringExtra("date");
                    String phone = returnIntent.getStringExtra("phone");
                    String email = returnIntent.getStringExtra("email");
                    Long lastUpdatedTime = System.currentTimeMillis();

                    if ((addr != null) && (link != null) && (rank != null) && (rooms != null)
                            && (bathrooms != null) && (price != null)) {
                        Prop prop = new Prop(addr, link, rank, rooms, bathrooms, price,
                                sqft, pets, date, phone, email,lastUpdatedTime,propGroupID,propPassword);
                        Toast.makeText(this, "Added " + addr, Toast.LENGTH_SHORT).show();
                        PropList propList = (PropList) getSupportFragmentManager()
                                .findFragmentById(com.example.project.forrent.R.id.proplist_fragment);
                        propList.addProp(prop);
                        Log.i("viewList1", "prop gid = " + prop.getGroupID() + " prop pass = " + prop.getPassword());
                        try {
                            DataStore.createProp(propList.props.get(propList.getProp(prop.getAddr())),
                                    getBaseContext().getApplicationContext());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            Storage.writeObject
                                    (getApplicationContext(), "proplist.forrent", propList);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
        }
    }
}


