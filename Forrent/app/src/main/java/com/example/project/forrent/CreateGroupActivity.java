package com.example.project.forrent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        txtGroupID.append("rndm_num_gen_return_val_here");
        groupID = "rndm_num_gen_return_val_here";

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
            Intent intent = new Intent(getApplication().getBaseContext(), MainActivity.class);
            intent.putExtra("groupID", groupID);
            intent.putExtra("password", groupPsswd);
            int CREATE_GROUP_INTENT = 2;
            setResult(RESULT_OK, intent);
            startActivityForResult(intent, CREATE_GROUP_INTENT);
        }
    }
}
