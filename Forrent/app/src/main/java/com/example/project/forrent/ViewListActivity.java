package com.example.project.forrent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.project.forrent.R.layout.activity_main);
        final PropList propList =
                (PropList) getSupportFragmentManager().findFragmentById
                        (com.example.project.forrent.R.id.proplist_fragment);
        if (getIntent().getStringExtra("groupID") != null) {
            propList.setGroupID(getIntent().getStringExtra("groupID"));
            propList.setPassword(getIntent().getStringExtra("password"));
            try {
                Storage.writeObject(getApplicationContext(), "proplist.forrent", propList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Log.i("ViewList_1", "propList groupID = " + propList.getGroupID());
        if (Storage.fileExists(getApplicationContext(), "proplist.forrent")) {
            try {
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
                String lastUpdatedTime = propList.props.get(position).getLastUpdatedTime();
                String groupID = propList.props.get(position).getGroupID();
                String password = propList.props.get(position).getPassword();

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
                intent2.putExtra("lastUpdatedTime", lastUpdatedTime);
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
                startActivityForResult(addItemIntent, ADD_ITEM_INTENT);
                return (true);
            case com.example.project.forrent.R.id.random:
                Intent randomEncryptIntent = new Intent(this, RandomEncryptActivity.class);
                startActivity(randomEncryptIntent);
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
                    String lastUpdatedTime = returnIntent.getStringExtra("lastUpdatedTime");
                    String groupID = returnIntent.getStringExtra("groupID");
                    String password = returnIntent.getStringExtra("password");

                    if ((addr != null) && (link != null) && (rank != null) && (rooms != null)
                            && (bathrooms != null) && (price != null)) {
                        Toast.makeText(this, "Added " + addr, Toast.LENGTH_SHORT).show();
                        PropList propList = (PropList) getSupportFragmentManager()
                                .findFragmentById(com.example.project.forrent.R.id.proplist_fragment);
                        propList.addProp(new Prop(addr, link, rank, rooms, bathrooms, price,
                                sqft, pets, date, phone, email,lastUpdatedTime,groupID,password));
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


