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
 * Edited by Rex on 5/30/2016.
 * Added the call to the encrypt password method of the RandomEncrypt class
 */
public class JoinGroupActivity extends AppCompatActivity {
    RandomEncrypt randEncrypt = new RandomEncrypt();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

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
        String groupID = checkNonEmpty(R.id.txtGroupID, "Group ID");
        String groupPsswd = checkNonEmpty(R.id.txtGroupPsswd, "Password");
        if (groupID != null && groupPsswd != null) {
            randEncrypt.setePassword(groupPsswd);
            groupPsswd = randEncrypt.getePassword();
            Toast.makeText(this, "Joined group " + groupID, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Encrypted Password " + groupPsswd, Toast.LENGTH_SHORT).show();
            PropList propList = (PropList) getSupportFragmentManager()
                    .findFragmentById(com.example.project.forrent.R.id.proplist_fragment);
            //check groupID and password against cloud data
            //if match, pull data from cloud and load it locally
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
