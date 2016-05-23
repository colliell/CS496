package com.example.project.forrent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anna on 5/3/16.
 *
 */
public class EditItemActivity extends AppCompatActivity {
    private ListView listView = null;
    private List<Map<String, String>> data;
    private static final String TAG = "1";
    private Prop propEdit;

    protected void onCreate(Bundle savedInstanceState) {
        //private String lastUpdatedTime;
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
        String lastUpdatedTime = getIntent().getStringExtra("lastUpdatedTime");
        String groupID = getIntent().getStringExtra("groupID");
        String password = getIntent().getStringExtra("password");

        propEdit = new Prop(addr, link, rank, rooms, bathrooms
                , price, sqft, pets, date, phone, email,lastUpdatedTime,groupID,password);
        PrepareData(propEdit);

        delectOldITem(addr);

        String[] from = {"addr", "link", "rank", "rooms", "bathrooms"
                , "price", "sqft", "pets", "date", "phone", "email"};
        int[] to = {R.id.editAddr, R.id.editLink, R.id.editrank, R.id.editrooms
                , R.id.editbathrooms, R.id.editprice, R.id.editsqft, R.id.editpets, R.id.editdate
                , R.id.editphone, R.id.editemail};

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
        hm.put("phone", prop.getPhone());
        hm.put("date", prop.getDate());
        hm.put("email", prop.getEmail());
        hm.put("lastUpdatedTime", prop.getLastUpdatedTime());
        data.add(hm);
    }

    public void onClick(View v) {
        EditText addr = (EditText) findViewById(R.id.editAddr);
        EditText link = (EditText) findViewById(R.id.editLink);
        EditText rank = (EditText) findViewById(R.id.editrank);
        EditText rooms = (EditText) findViewById(R.id.editrooms);
        EditText bathrooms = (EditText) findViewById(R.id.editbathrooms);
        EditText price = (EditText) findViewById(R.id.editprice);
        EditText sqrt = (EditText) findViewById(R.id.editsqft);
        EditText pets = (EditText) findViewById(R.id.editpets);
        EditText date = (EditText) findViewById(R.id.editdate);
        EditText phone = (EditText) findViewById(R.id.editphone);
        EditText email = (EditText) findViewById(R.id.editemail);

        String addrString = addr.getText().toString();
        String linkString = link.getText().toString();
        String rankString = rank.getText().toString();
        String roomsString = rooms.getText().toString();
        String bathroomsString = bathrooms.getText().toString();
        String priceString = price.getText().toString();
        String sqrtString = sqrt.getText().toString();
        String petsString = pets.getText().toString();
        String dateString = date.getText().toString();
        String phoneString = phone.getText().toString();
        String emailString = email.getText().toString();

        DateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
        lastUpdatedTime = df.format(Calendar.getInstance().getTime());
        Log.i(TAG, "My currrent time is ~~~~~~~~~~" + lastUpdatedTime);
        String groupID = propEdit.getGroupID().toString();
        String password = propEdit.getPassword().toString();

        //Log.i(TAG, "My after edit item addr is ~~~~~~~~~~" + addr.getText().toString());
        Intent intent = new Intent(EditItemActivity.this, DetailActivity.class);
        intent.putExtra("addr", addrString);
        intent.putExtra("link", linkString);
        intent.putExtra("rank", rankString);
        intent.putExtra("rooms", roomsString);
        intent.putExtra("bathrooms", bathroomsString);
        intent.putExtra("price", priceString);
        intent.putExtra("sqft", sqrtString);
        intent.putExtra("pets", petsString);
        intent.putExtra("date", dateString);
        intent.putExtra("phone", phoneString);
        intent.putExtra("email", emailString);
        intent.putExtra("lastUpdatedTime", lastUpdatedTime);
        intent.putExtra("groupID", groupID);
        intent.putExtra("password", password);


        saveNewItem(addrString, linkString, rankString, roomsString, bathroomsString
                , priceString, sqrtString, petsString, dateString, phoneString
                , emailString, lastUpdatedTime, groupID, password);
        startActivity(intent);
        finish();
    }

    public void delectOldITem(String addr) {
        PropList propList = new PropList();
        if (Storage.fileExists(getApplicationContext(), "proplist.forrent")) {
            try {
                PropList storedList = (PropList) Storage
                        .readObject(getApplication().getBaseContext(), "proplist.forrent");
                Log.i("In Delet old term", " ~~~~~~~~~~~~~= " + addr);
                propList.deleteProp(storedList, addr);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }try {
            Storage.writeObject(getApplicationContext(), "proplist.forrent", propList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveNewItem(String addr, String link, String rank,
                            String rooms, String bathrooms, String price, String sqft,
                            String pets, String date, String phone, String email,
                            String lastUpdatedTime,String groupID,String password) {
        PropList propList = new PropList();
        try {
            PropList storedList = (PropList) Storage
                    .readObject(getApplication().getBaseContext(), "proplist.forrent");
            propList.addEditProp(new Prop(addr, link, rank, rooms, bathrooms,
                    price, sqft, pets, date, phone, email,lastUpdatedTime,groupID,password));
            propList.mergeEditProp(storedList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Storage.writeObject(getApplicationContext(), "proplist.forrent", propList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
