package com.example.project.forrent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.project.forrent.R.layout.activity_main);
        final PropList propList =
                (PropList) getSupportFragmentManager().findFragmentById
                        (com.example.project.forrent.R.id.proplist_fragment);
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        //uncomment the following line to test new user page
        //preferences.edit().remove("first_run").apply();
        //if (preferences.getBoolean("first_run", true) || propList.getGroupID == null) {
        if (preferences.getBoolean("first_run", true)) {
            Intent newUserIntent = new Intent(this, NewUserActivity.class);
            startActivity(newUserIntent);
            preferences.edit().putBoolean("first_run", false).apply();
        } else if(Storage.fileExists(getApplicationContext(), "proplist.forrent")) {
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
        // else check groupID and password, pull from cloud

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String addr = propList.props.get(position).getAddr();
                String link = propList.props.get(position).getLink();
                String rank = propList.props.get(position).getRank();
                String rooms = propList.props.get(position).getRooms();
                String bathrooms = propList.props.get(position).getBathrooms();
                //Log.i("1", "bathrooms = " + bathrooms);
                String price = propList.props.get(position).getPrice();
                String sqft = propList.props.get(position).getSqft();
                String pets = propList.props.get(position).getPets();
                String date = propList.props.get(position).getDate();
                String phone = propList.props.get(position).getPhone();
                String email = propList.props.get(position).getEmail();
                String lastUpdatedTime = propList.props.get(position).getLastUpdatedTime();
                String groupID = propList.props.get(position).getGroupID();
                String password = propList.props.get(position).getPassword();

                Intent intent2 = new Intent(MainActivity.this, DetailActivity.class);
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
    final static int CREATE_GROUP_INTENT = 2;
    final static int JOIN_GROUP_INTENT = 3;

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
                case CREATE_GROUP_INTENT:
                    groupID = returnIntent.getStringExtra("groupID");
                    password = returnIntent.getStringExtra("password");
                    Log.w("1", "CREATE: group id = " + groupID + " password = " + password);
                    if (groupID != null && password != null) {
                        Toast.makeText(this, "Created group " + groupID, Toast.LENGTH_SHORT).show();
                        PropList propList = (PropList) getSupportFragmentManager()
                                .findFragmentById(com.example.project.forrent.R.id.proplist_fragment);
                        //propList.setGroupID(groupID);
                        //propList.setGroupPsswd(password);
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                    }
                    break;
                case JOIN_GROUP_INTENT:
                    groupID = returnIntent.getStringExtra("groupID");
                    password = returnIntent.getStringExtra("password");
                    Log.w("1", "JOIN: group id = " + groupID + " password = " + password);
                    if (groupID != null && password != null) {
                        Toast.makeText(this, "Joined group " + groupID, Toast.LENGTH_SHORT).show();
                        PropList propList = (PropList) getSupportFragmentManager()
                                .findFragmentById(com.example.project.forrent.R.id.proplist_fragment);
                        //propList.getGroupID(groupID);
                        //propList.getGroupPsswd(password);
                        //pull data from cloud, load it locally
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                    }
                    break;
            }
        }
    }
}
