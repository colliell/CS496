package com.example.project.forrent;

import android.content.Intent;
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
        //Log.w("testinglog", "get he &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        if(Storage.fileExists(getApplicationContext(), "proplist.forrent")) {
            //Log.w("testinglog", "get here &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
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

                //Log.i("1","My item position is ~~~~~~~~~~"+  position+ propList.props.get(position).getAddr());

                String addr = propList.props.get(position).getAddr();
                String link = propList.props.get(position).getLink();
                String rank = propList.props.get(position).getRank();
                String rooms = propList.props.get(position).getRooms();
                String bathrooms = propList.props.get(position).getBathrooms();
                //Log.i("1", "bathrooms = " + bathrooms);
                String price = propList.props.get(position).getPrice();
                String sqft = propList.props.get(position).getSqft();
                String pets = propList.props.get(position).getPets();

                Intent intent2 = new Intent(MainActivity.this, DetailActivity.class);
                intent2.putExtra("link", link);
                intent2.putExtra("addr", addr);
                intent2.putExtra("rank", rank);
                intent2.putExtra("rooms", rooms);
                intent2.putExtra("bathrooms", bathrooms);
                intent2.putExtra("price", price);
                intent2.putExtra("sqft", sqft);
                intent2.putExtra("pets", pets);
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
    static final int List_Item = 1;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case com.example.project.forrent.R.id.add:
                Intent addItemIntent = new Intent(this, AddItemActivity.class);
                startActivityForResult(addItemIntent, ADD_ITEM_INTENT);
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
                    if ((addr != null) && (link != null) && (rank != null) && (rooms != null)
                            && (bathrooms != null) && (price != null)) {
                        Toast.makeText(this, "Added " + addr, Toast.LENGTH_SHORT).show();
                        PropList propList = (PropList) getSupportFragmentManager()
                                .findFragmentById(com.example.project.forrent.R.id.proplist_fragment);
                        propList.addProp(new Prop(addr, link, rank, rooms, bathrooms, price, sqft, pets));
                        try {
                            Storage.writeObject
                                    (getApplicationContext(), "proplist.forrent", propList);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                // could handle other intent callbacks here, too
            }
        }
    }
}
