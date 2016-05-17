package com.example.project.forrent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Reilly on 5/16/2016.
 * Startup page for new user to create or join group.
 */
public class NewUserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        Button btn_CreateGroup = (Button) (this.findViewById(R.id.create_group));
        btn_CreateGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createGroup();
            }
        });

        Button btn_JoinGroup = (Button) (this.findViewById(R.id.join_group));
        btn_JoinGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinGroup();
            }
        });

    }

    private void joinGroup() {
    }

    private void createGroup() {
    }

}
