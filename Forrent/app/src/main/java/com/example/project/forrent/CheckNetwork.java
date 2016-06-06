package com.example.project.forrent;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Rex M Henzie on 6/5/2016.
 */
public class CheckNetwork {
    Context myContext;
    public CheckNetwork(Context myContext){
        this.myContext = myContext;
    }

    public boolean netCheck(){
        ConnectivityManager cm = (ConnectivityManager)
                myContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
}
