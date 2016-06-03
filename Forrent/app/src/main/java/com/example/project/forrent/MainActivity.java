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
        //Log.i("MainActivity_1", "propList groupID = " + propList.getGroupID());
        if (Storage.fileExists(getApplicationContext(),
                "proplist.forrent") || propList.isGroupIDSet()) {
            try {
                PropList storedList = (PropList) Storage
                        .readObject(getApplicationContext(), "proplist.forrent");
                if (preferences.getBoolean("first_run", true) || !storedList.isGroupIDSet()) {
                    preferences.edit().putBoolean("first_run", false).apply();
                    Intent newUserIntent = new Intent(MainActivity.this, NewUserActivity.class);
                    startActivity(newUserIntent);

                } else {
                    propList.merge(storedList);
                    Intent viewListIntent = new Intent(this, ViewListActivity.class);
                    viewListIntent.putExtra("groupID", storedList.getGroupID());
                    viewListIntent.putExtra("password", storedList.getPassword());
                    startActivity(viewListIntent);
                }
            } catch (IOException e) {
                Intent newUserIntent = new Intent(this, NewUserActivity.class);
                startActivity(newUserIntent);
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            Intent newUserIntent = new Intent(this, NewUserActivity.class);
            startActivity(newUserIntent);
        }
    }
}
