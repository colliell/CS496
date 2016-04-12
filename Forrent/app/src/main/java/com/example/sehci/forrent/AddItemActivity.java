package com.example.sehci.forrent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.sehci.forrent.R.layout.activity_add_item);

        Button btnOk = (Button) (this.findViewById(com.example.sehci.forrent.R.id.btnOK));
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
        Toast.makeText(this, info + " is required", Toast.LENGTH_SHORT).show();
        return null;
    }

    private void validateSaveExit() {
        String author = checkNonEmpty(com.example.sehci.forrent.R.id.txtAuthor, "author");
        String title = checkNonEmpty(com.example.sehci.forrent.R.id.txtTitle, "title");
        if (author != null && title != null) {
            // return result
            Intent intent = new Intent();
            intent.putExtra("author", author);
            intent.putExtra("title", title);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
