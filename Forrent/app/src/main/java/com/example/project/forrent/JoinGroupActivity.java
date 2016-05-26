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
public class JoinGroupActivity extends AppCompatActivity {
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
        Intent intent = new Intent(getApplication().getBaseContext(), MainActivity.class);
        intent.putExtra("groupID", groupID);
        intent.putExtra("password", groupPsswd);
        int JOIN_GROUP_INTENT = 3;
        setResult(RESULT_OK, intent);
        startActivityForResult(intent, JOIN_GROUP_INTENT);
    }
}
