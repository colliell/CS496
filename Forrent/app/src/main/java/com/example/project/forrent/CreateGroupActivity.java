package com.example.project.forrent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Reilly on 5/24/2016.
 * Activity to create a new forrent group.
 */
public class CreateGroupActivity extends AppCompatActivity {
    String groupID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        TextView txtGroupID = (TextView) (findViewById(R.id.txtGroupID));
        //String rand_num = getRandNum().toString();
        groupID = "0485857";
        txtGroupID.append(groupID);


        Button btnOk = (Button) (this.findViewById(com.example.project.forrent.R.id.btnOK));
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateSaveExit();

            }
        });
    }

    private String checkNonEmpty(int id, String info) {
        TextView textView = (TextView) (findViewById(id));
        if (textView != null) {
            CharSequence txt = textView.getText();
            if (txt != null) {
                int len = txt.length();
                if (len > 0) {
                    return txt.toString();
                }
            }
            textView.setHint(info + " is required");
        }
        return null;
    }


    private void validateSaveExit() {

        String groupPsswd = checkNonEmpty(R.id.txtGroupPsswd, "Password");
        if (groupPsswd != null && groupID != null) {
            Toast.makeText(this, "Created group " + groupID, Toast.LENGTH_SHORT).show();
            PropList propList = (PropList) getSupportFragmentManager()
                    .findFragmentById(com.example.project.forrent.R.id.proplist_fragment);
            //propList.setGroupID(groupID);
            //propList.setGroupPsswd(password);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
