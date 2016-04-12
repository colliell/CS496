package com.example.sehci.forrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

public class BookList extends ListFragment {
    int[] logos = new int[]{
            com.example.sehci.forrent.R.drawable.blue,
            com.example.sehci.forrent.R.drawable.green,
            com.example.sehci.forrent.R.drawable.orange,
            com.example.sehci.forrent.R.drawable.pink
    };

    List<Book> books = new ArrayList<Book>(Arrays.asList(new Book[]{
            new Book("Dune", "Frank Herbert"),
            new Book("Foundation", "Isaac Asimov"),
            new Book("Brave New World", "Aldrus Huxley"),
            new Book("Snow Crash", "Neal Stephenson"),
            new Book("Diamond Age", "Neal Stephenson"),
            new Book("Cryptonomicon", "Neal Stephenson")
    }));

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setupList();

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void setupList() {
        List<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("title", book.getTitle());
            hm.put("subtitle", book.getAuthor());
            hm.put("logo", Integer.toString(logos[i % logos.length]));
            rows.add(hm);
        }
        String[] from = {"logo", "title", "subtitle"};
        int[] to = {com.example.sehci.forrent.R.id.logo, com.example.sehci.forrent.R.id.title, com.example.sehci.forrent.R.id.subtitle};

        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), rows, com.example.sehci.forrent.R.layout.listview_layout, from, to);
        setListAdapter(adapter);
    }

    public void addBook(Book book) {
        books.add(book);
        setupList();
    }
}