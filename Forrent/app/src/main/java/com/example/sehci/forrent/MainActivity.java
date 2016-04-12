package com.example.sehci.forrent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.sehci.forrent.R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.example.sehci.forrent.R.menu.menu_main, menu);
        return true;
    }

    final static int ADD_ITEM_INTENT = 1; // use to signify result of adding item

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case com.example.sehci.forrent.R.id.add:
                Intent addItemIntent = new Intent(this, AddItemActivity.class);
                startActivityForResult(addItemIntent, ADD_ITEM_INTENT);
                return (true);

            // BTW, you could handle other menu items here, if your menu had them
        }
        return (super.onOptionsItemSelected(item));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent returnIntent) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case ADD_ITEM_INTENT:
                    String title = returnIntent.getStringExtra("title");
                    String author = returnIntent.getStringExtra("author");
                    if (title != null && author != null) {
                        Toast.makeText(this, title + " (" + author + ")", Toast.LENGTH_SHORT).show();
                        BookList bookList = (BookList)
                                getSupportFragmentManager().findFragmentById(com.example.sehci.forrent.R.id.booklist_fragment);
                        bookList.addBook(new Book(title, author));
                    }
                    break;
                // could handle other intent callbacks here, too
            }
        }
    }

}
