package com.example.project.forrent;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.TravelMode;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Reilly on 5/2/2016.
 * Activity for displaying google map.
 */


public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final String CORVALLIS_OR = " Corvallis, OR";
    private static final float ZOOM_VALUE = 15;
    private static final String MU_ADDR = "2501 SW Jefferson Way" + CORVALLIS_OR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap map) {

        String addr = getIntent().getStringExtra("addr");
        //Log.i("1", "addr = " + addr);
        String newAddr = addr + CORVALLIS_OR;
        //Log.i("1", "newAddr = " + newAddr);

        GeoApiContext context =
                new GeoApiContext().setApiKey("AIzaSyC7qg6X1jDxmyh02klxUwPwP_juEl5Re5w");
        GeocodingResult[] results = new GeocodingResult[0];
        try {
            results = GeocodingApi.geocode(context, newAddr).await();
        } catch (Exception e) {
            Toast.makeText(this, "Address " + addr + " not valid", Toast.LENGTH_SHORT).show();
            finish();
        }

        Double addrLat = results[0].geometry.location.lat;
        Double addrLong = results[0].geometry.location.lng;

        LatLng addrOnMap = new LatLng(addrLat, addrLong);

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(addrOnMap, ZOOM_VALUE));
        map.getUiSettings().setZoomControlsEnabled(true);

        map.addMarker(new MarkerOptions()
                .title(newAddr)
                .position(addrOnMap));

        String duration = DistanceMatrixApi.newRequest(context).origins(newAddr).destinations(MU_ADDR)
                .mode(TravelMode.WALKING).awaitIgnoreError().rows[0].elements[0].duration.humanReadable;
        TextView durationText = (TextView) findViewById(R.id.duration);
        durationText.append(duration);

    }



}
