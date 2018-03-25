package com.hamburgcodingschool.example.mapbox;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateManager;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    private MapView mapView;
    private MapboxMap map;

    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, getString(R.string.mapbox_key));
        setContentView(R.layout.activity_main);
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        checkForUpdates();
        final Icon icon = IconFactory.getInstance(MainActivity.this).fromResource(R.drawable.ic_directions_car);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                map = mapboxMap;
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(48.775846, 9.182932))
                        .title("Stuttgart")
                        .snippet("Baden-Württemberg")
                        .icon(icon)
                );
                mapboxMap.setOnInfoWindowClickListener(new MapboxMap.OnInfoWindowClickListener() {
                    @Override
                    public boolean onInfoWindowClick(@NonNull Marker marker) {
                        LatLng position = marker.getPosition();
                        String location = "https://www.google.com/maps?ll=" + position.getLatitude() + ","
                                + position.getLongitude() + "&q=" + position.getLatitude() + ","
                                + position.getLongitude();
                        Intent sendIntent = new Intent(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT, location);
                        sendIntent.setType("text/plain");
                        startActivity(Intent.createChooser(sendIntent, "Send location"));
                        return true;
                    }
                });
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    mapboxMap.setMyLocationEnabled(true);
                } else {
                    //Request Location Permission
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            MY_PERMISSIONS_REQUEST_LOCATION);
                }
            }
        });

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareLocation();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
        checkForCrashes();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
        unregisterManagers();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
        unregisterManagers();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    private void checkForCrashes() {
        CrashManager.register(this);
    }

    private void checkForUpdates() {
        // Remove this for store builds!
        UpdateManager.register(this);
    }

    private void unregisterManagers() {
        UpdateManager.unregister();
    }

    @SuppressWarnings("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST_LOCATION) {
            if (permissions.length == 1 &&
                    Manifest.permission.ACCESS_FINE_LOCATION.equals(permissions[0]) &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                map.setMyLocationEnabled(true);
            }
        }
    }

    private void shareLocation() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            String locationUrl = "https://www.google.com/maps?ll="
                                    + location.getLatitude() + "," + location.getLongitude()
                                    + "&q=" + location.getLatitude() + "," + location.getLongitude();
                            Intent sendIntent = new Intent(Intent.ACTION_SEND);
                            sendIntent.putExtra(Intent.EXTRA_TEXT, locationUrl);
                            sendIntent.setType("text/plain");
                            startActivity(Intent.createChooser(sendIntent, "Send location"));
                        }
                    }
                });
    }
}
