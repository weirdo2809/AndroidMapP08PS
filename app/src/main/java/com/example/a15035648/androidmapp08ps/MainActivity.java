package com.example.a15035648.androidmapp08ps;

import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter;
        List<String> list;
        list = new ArrayList<String>();
        list.add("Unselected");
        list.add("North");
        list.add("Central");
        list.add("East");

        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                String yourName = spinner.getSelectedItem().toString();
                if (yourName == "Unselected") {

                } else if (yourName == "North") {
                    LatLng Singapore = new LatLng(1.441073, 103.77207);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(Singapore,
                            20));
                    Toast.makeText(MainActivity.this, "North Branch", Toast.LENGTH_SHORT).show();
                }  else if (yourName == "Central") {
                    LatLng Singapore = new LatLng(1.297802, 103.847441);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(Singapore,
                            20));
                    Toast.makeText(MainActivity.this, "Central Branch", Toast.LENGTH_SHORT).show();
                }else {
                    LatLng Singapore = new LatLng(1.367149, 103.928021);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(Singapore,
                            20));
                    Toast.makeText(MainActivity.this, "East Branch", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)
                fm.findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                LatLng Singapore = new LatLng(1.352083, 103.819836);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Singapore,
                        10));
                UiSettings ui = map.getUiSettings();
                ui.setCompassEnabled(true);
                ui.setZoomControlsEnabled(true);
                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION);

                if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);
                } else {
                    Log.e("GMap - Permission", "GPS access has not been granted");
                }
                LatLng branch1 = new LatLng(1.441073, 103.77207);
                Marker cp = map.addMarker(new
                        MarkerOptions()
                        .position(branch1)
                        .title("North - HQ")
                        .snippet("Block 333, Admiralty Ave 3, 765654 Operating hours: 10am-5pm\n" +
                                "Tel:65433456\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng branch2 = new LatLng(1.297802, 103.847441);
                Marker rp = map.addMarker(new
                        MarkerOptions()
                        .position(branch2)
                        .title("Central")
                        .snippet("Block 3A, Orchard Ave 3, 134542 \n" +
                                "Operating hours: 11am-8pm\n" +
                                "Tel:67788652\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng branch3 = new LatLng(1.367149, 103.928021);
                Marker dp = map.addMarker(new
                        MarkerOptions()
                        .position(branch3)
                        .title("East")
                        .snippet("Block 555, Tampines Ave 3, 287788 \n" +
                                "Operating hours: 9am-5pm\n" +
                                "Tel:66776677\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

            }
        });

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng Singapore = new LatLng(1.441073, 103.77207);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Singapore,
                        20));
                Toast.makeText(MainActivity.this, "North Branch", Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng Singapore = new LatLng(1.297802, 103.847441);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Singapore,
                        20));
                Toast.makeText(MainActivity.this, "Central Branch", Toast.LENGTH_SHORT).show();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng Singapore = new LatLng(1.367149, 103.928021);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Singapore,
                        20));
                Toast.makeText(MainActivity.this, "East Branch", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
