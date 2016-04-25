package com.example.project.forrent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.project.forrent.R.layout.activity_main);
        Log.w("testinglog", "get he &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        if(Storage.fileExists(getApplicationContext(), "proplist.forrent")) {
            PropList propList =
                    (PropList) getSupportFragmentManager().findFragmentById(com.example.project.forrent.R.id.proplist_fragment);
            Log.w("testinglog", "get here &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            try {
                PropList storedList = (PropList) Storage.readObject(getApplicationContext(), "proplist.forrent");
                propList.merge(storedList);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

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
                            Storage.writeObject(getApplicationContext(), "proplist.forrent", propList);
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
