package com.yezarougmail.parkingmalaga;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    ArrayList<Parking> list_parking;
    ListView parkings;
    GoogleMap _map;
    Location actual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        parkings = findViewById(R.id.listview);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        long minTime = 1000;
        float minDistance = 4;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    10);
        }

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                actual = location;
                Log.d("LOCALIZACION",actual.getLatitude() + " " + actual.getLongitude());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        });

        Intent intent = this.getIntent();
        if (intent != null) {
            list_parking = (ArrayList<Parking>) intent.getExtras().get("ListaParking");
            ListAdapter adapter = new ParkingAdapter(this, R.layout.parkingitem, list_parking);
            parkings.setAdapter(adapter);
        }

        parkings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ponerPunto(list_parking.get(i));
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng greenRay = new LatLng(36.71853911463124,-4.496980905532837);
        int zoom = 17;

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(greenRay, zoom));
        googleMap.addMarker(new MarkerOptions()
                .title("The Green Ray")
                .snippet("SamsungTech.")
                .position(greenRay));

        _map = googleMap;
    }

    public void onClickCercano (View view){
        Location masCercano = new Location("Mas Cercano");
        Parking pk = new Parking(0,"");
        masCercano.setLatitude(list_parking.get(0).getLatitude());
        masCercano.setLongitude(list_parking.get(0).getLongitude());

        Location GreenRay = actual;

        for (Parking parking : list_parking){
            Location sigParking = new Location(parking.getNombre());
            sigParking.setLongitude(parking.getLongitude());
            sigParking.setLatitude(parking.getLatitude());

            if (GreenRay.distanceTo(masCercano) >= GreenRay.distanceTo(sigParking)) {
                masCercano = sigParking;
                pk = parking;
            }
        }

        ponerPunto(pk);
    }

    private void ponerPunto(Parking parking){
        _map.clear();
        LatLng marker = new LatLng(parking.getLatitude(), parking.getLongitude());
        int zoom = 17;
        _map.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, zoom));
        _map.addMarker(new MarkerOptions()
                .title(parking.getNombre())
                .snippet("(" + parking.getLibres() + "/" + parking.getCapacidad() + ")")
                .position(marker));
    }
}
