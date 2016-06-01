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
 * Edited by Rex on 5/26/2016.
 * Added the call to random number method and call to encrypt password method of the RandomEncrypt class
 */
public class CreateGroupActivity extends AppCompatActivity {
	RandomEncrypt randEncrypt = new RandomEncrypt();
    String groupID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        TextView txtGroupID = (TextView) (findViewById(R.id.txtGroupID));
        randEncrypt.setRandomNum();
		Integer randomNum = randEncrypt.getRandomNum();
        //String rand_num = getRandNum().toString();
        //groupID = "0485857";
		groupID = Integer.toString(randomNum);
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
			randEncrypt.setePassword(groupPsswd);
			groupPsswd = randEncrypt.getePassword();
            Toast.makeText(this, "Created group " + groupID, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Encrypted Password " + groupPsswd, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ViewListActivity.class);
            intent.putExtra("groupID", groupID);
            intent.putExtra("password", groupPsswd);
            startActivity(intent);
        }
    }
}
