package com.example.project.forrent;
/**
 * Updated by Rex M Henzie on 4/21/2016.
 * Added rank, rooms, bathrooms, price, sqft, and pets input
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddItemActivity extends AppCompatActivity {
    private Long lastUpdatedTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.project.forrent.R.layout.activity_add_item);

        Button btnOk = (Button) (this.findViewById(com.example.project.forrent.R.id.btnOK));
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
                lastUpdatedTime = System.currentTimeMillis();
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

    private String check(int id) {
        TextView textView = (TextView) (findViewById(id));
        if (textView != null) {
            CharSequence txt = textView.getText();
            if (txt != null) {
                int len = txt.length();
                if (len > 0) {
                    return txt.toString();
                }
            }
        }
        return null;
    }

    private void validateSaveExit() {
        String link = checkNonEmpty(com.example.project.forrent.R.id.txtLink, "link");
        String addr = checkNonEmpty(com.example.project.forrent.R.id.txtAddr, "addr");
        String rank = checkNonEmpty(com.example.project.forrent.R.id.txtrank, "rank");
        String rooms = checkNonEmpty(com.example.project.forrent.R.id.txtrooms, "rooms");
        String bathrooms = checkNonEmpty(com.example.project.forrent.R.id.txtbathrooms, "bathrooms");
        String price = checkNonEmpty(com.example.project.forrent.R.id.txtprice, "price");
        String sqft = check(com.example.project.forrent.R.id.txtsqft);
        String pets = check(com.example.project.forrent.R.id.txtpets);
        String date = check(R.id.txtdate);
        String phone = check(R.id.txtphone);
        String email = check(R.id.txtemail);
        String groupID = getIntent().getStringExtra("groupID");
        String password = getIntent().getStringExtra("password");
        if ((addr != null) && (link != null) && (rank != null) && (rooms != null)
                && (bathrooms != null) && (price != null)) {
            // return result
            Intent intent = new Intent();
            intent.putExtra("link", link);
            intent.putExtra("addr", addr);
            intent.putExtra("rank", rank);
            intent.putExtra("rooms", rooms);
            intent.putExtra("bathrooms", bathrooms);
            intent.putExtra("price", price);
            intent.putExtra("sqft", sqft);
            intent.putExtra("pets", pets);
            intent.putExtra("date", date);
            intent.putExtra("phone", phone);
            intent.putExtra("email", email);
            intent.putExtra("lastUpdatedTime", lastUpdatedTime);
            intent.putExtra("groupID", groupID);
            intent.putExtra("password", password);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
