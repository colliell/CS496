package com.example.project.forrent;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;

/**
 * Created by Reilly on 6/4/2016.
 * Activity to view stats
 */
public class StatsActivity extends AppCompatActivity {
    String propPassword;
    String propGroupID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        propPassword = getIntent().getStringExtra("password");
        propGroupID = getIntent().getStringExtra("groupID");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        final Button btn = (Button) (this.findViewById(R.id.stats));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setEnabled(false);
                new asyncTask().execute();
            }
        });
    }

    private class asyncTask extends AsyncTask<Integer, Integer, Map> {
        @Override
        protected void onPreExecute() {
            // runs on UI thread, to prepare for our task
            ((TextView) findViewById(R.id.txtInfo)).setText("Getting stats...");
        }

        @Override
        protected Map doInBackground(Integer... params) {
            int param = 0;
            for (int i = 0; i < 100; i++)
                param++;
            // runs in background thread, performing the task
            //cloud stuff
            return DataStore.getStats(propGroupID,propPassword);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

        }

        @Override
        protected void onPostExecute(Map statsMap) {
            // runs on UI thread, to display final result
            ((TextView) findViewById(R.id.txtInfo)).setText("Done");
            ((TextView) findViewById(R.id.statistics1))
                    .append(statsMap.get("Statistic1").toString());
            ((TextView) findViewById(R.id.statistics2))
                    .append(statsMap.get("Statistic2").toString());
            ((TextView) findViewById(R.id.statistics3))
                    .append(statsMap.get("Statistic3").toString());

        }
    }

}
