package com.trashguard.trashgaurd.View;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.trash.trashguard.R;

public class HomeView extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener {
    private static final int MY_REQUEST_INT = 177;
    private static final String TAG = "MapActivity";
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private static final float DEFAULT_ZOOM = 15f;
    private GoogleMap mMap;
    private ImageButton add_complain;
    private Toolbar toolbar;
    private ImageView profilepic;
    private ImageView history_button;
    private ImageView home_button;
    private ImageView notifications_button;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private Boolean mLocationPermissionsGranted = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initButtons();
        initMap();
//        getLocationPermission();

    }

    private void initButtons() {
        Log.d(TAG, "initButtons: Button Initialized");
        home_button = (ImageView) findViewById(R.id.home);
        history_button = (ImageView) findViewById(R.id.history);
        add_complain = (ImageButton) findViewById(R.id.add_complain);
        notifications_button = (ImageView) findViewById(R.id.notification);
        profilepic = (ImageView) findViewById(R.id.profile_pic4);

    }


    private void initMap() {
        Log.d(TAG, "initMap: initializing map");
        Toast.makeText(this, "Map is ready", Toast.LENGTH_SHORT).show();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void getDeviceLocation() {
        Log.d(TAG, "getDeviceLocation: getting device location");

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        try {
            Task<Location> location = mFusedLocationProviderClient.getLastLocation();
            location.addOnCompleteListener(new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    if (task.isSuccessful() && task.getResult() != null) {
                        Log.d(TAG, "onComplete: Found device location");
                        Location currentLocation = (Location) task.getResult();

                        moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()), DEFAULT_ZOOM);
                    } else {
                        Log.d(TAG, "onComplete: current locations is null");
                        Toast.makeText(HomeView.this, "Unable to get current location", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        } catch (SecurityException e) {
            Log.d(TAG, "getDeviceLocation: Security Exception" + e.getMessage());
        }
    }

    private void moveCamera(LatLng latLng, float zoom) {
        Log.d(TAG, "moveCamera: moving camera to: lat:" + latLng.latitude + ",long :" + latLng.longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
    }

//    private void getLocationPermission(){
//        Log.d(TAG,"getLocationPermission: getting location permission");
//        String[] permissions = {Manifest.permission .ACCESS_FINE_LOCATION,
//        Manifest.permission.ACCESS_COARSE_LOCATION};
//        if (Build.VERSION.SDK_INT >= 23) {
//            if (ContextCompat.checkSelfPermission(HomeView.this,
//                    FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//                Log.d(TAG, "PERMISSION: FINE_LOCATION GRANTED");
//                if (ContextCompat.checkSelfPermission(HomeView.this,
//                        COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//                    Log.d(TAG, "PERMISSION: COURSE_LOCATIOn GRANTED");
//                    mLocationPermissionsGranted = true;
//                } else {
//                    Log.d(TAG, "Inner If: PERMISSION ASKED");
//                    ActivityCompat.requestPermissions(HomeView.this,
//                            permissions,
//                            LOCATION_PERMISSION_REQUEST_CODE);
//                }
//            } else {
//                Log.d(TAG, "Outer     If: PERMISSION ASKED");
//                ActivityCompat.requestPermissions(HomeView.this,
//                        permissions,
//                        LOCATION_PERMISSION_REQUEST_CODE);
//
//            }
//        }else
//            Log.d(TAG,"SDK NOT VALID");
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        Log.d(TAG,"onRequestPermissionResult: called");
//        mLocationPermissionsGranted = false;
//
//        switch (requestCode){
//            case LOCATION_PERMISSION_REQUEST_CODE:{
//                if(grantResults.length > 0) {
//                    for(int i =0 ; i < grantResults.length; i++) {
//                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
//                            mLocationPermissionsGranted = false;
//                            Log.d(TAG,"onRequestPermissionResult: permission failed");
//                            return;
//                        }
//                    }
//                    Log.d(TAG,"onRequestPermissionResult: permission granted");
//                    mLocationPermissionsGranted = true;
//                    //initialize map
////                    initMap();
//                }
//            }
//        }
//    }

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
        Log.d(TAG, "onMapReady: map is ready");
        mMap = googleMap;

//        // Add a marker in Sydney and move the camera
//        LatLng house = new LatLng(10.299506, 123.870354);
//        mMap.addMarker(new MarkerOptions().position(house).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(house));
        getDeviceLocation();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
    }

    @Override
    public void onBackPressed() {
        Intent mainActivity = new Intent(Intent.ACTION_MAIN);
        mainActivity.addCategory(Intent.CATEGORY_HOME);
        mainActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mainActivity);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.add_complain:
                    add_complain.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(HomeView.this, AddComplainView.class);
                            startActivity(i);
                        }
                    });
                    break;

            case R.id.notification:
                    notifications_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(HomeView.this, NotificationsView.class);
                            startActivity(i);
                        }
                    });
                    break;
            case R.id.profile_pic:
                    profilepic.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(HomeView.this,ProfileView.class);
                            startActivity(i);
                        }
                    });
                    break;
            case R.id.history:
                    history_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(HomeView.this, ComplaintHistoryView.class);
                            startActivity(i);
                        }
                    });
                    break;
            case R.id.home:
                    home_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(HomeView.this, "Already home.", Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
        }
    }
}

