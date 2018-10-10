package com.trashguard.trashgaurd.View;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.trash.trashguard.R;

public class HomeView extends AppCompatActivity implements OnMapReadyCallback {
    private static final int MY_REQUEST_INT = 177;
    private GoogleMap mMap;
    private ImageButton add_complain;
    private Toolbar toolbar;
    private ImageView history_button;
    private ImageView home_button;
    private ImageView notifications_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        home_button = (ImageView) findViewById(R.id.home);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeView.this, "Already home.", Toast.LENGTH_SHORT).show();
            }
        });

        history_button = (ImageView) findViewById(R.id.history);
        history_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeView.this, ComplaintHistoryView.class);
                startActivity(i);
            }
        });
        add_complain = (ImageButton) findViewById(R.id.add_complain);
        add_complain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeView.this, AddComplainView.class);
                startActivity(i);
            }
        });

        notifications_button = (ImageView) findViewById(R.id.notification);
        notifications_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeView.this, NotificationsView.class);
                startActivity(i);
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in Sydney and move the camera
        LatLng house = new LatLng(10.299506, 123.870354);
        mMap.addMarker(new MarkerOptions().position(house).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(house));
    }

    @Override
    public void onBackPressed() {
        Intent mainActivity = new Intent(Intent.ACTION_MAIN);
        mainActivity.addCategory(Intent.CATEGORY_HOME);
        mainActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mainActivity);
        finish();
    }
}
