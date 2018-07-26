package com.example.joseamontenegromontes.musculacionmalaga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    // Variables de clase
    ArrayList<ZonaMusculacion> zonasMusculacion ;
    ListView listaZonas;
    GoogleMap _map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        listaZonas = (ListView) findViewById(R.id.listViewZonas);

        Intent intent = getIntent();
        if (intent != null){
            zonasMusculacion = (ArrayList<ZonaMusculacion>) intent.getExtras().get(MainActivity.LISTA_ZONAS);
            ZonaMusculacionAdapter adapter = new ZonaMusculacionAdapter(this, R.layout.zona_layout, zonasMusculacion);
            listaZonas.setAdapter(adapter);
        }

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        listaZonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ponerPunto(zonasMusculacion.get(position));
            }
        });
    }

    public void ponerPunto(ZonaMusculacion zona){
        _map.clear();
        LatLng ubicacion = new LatLng(zona.getLatitude(), zona.getLongitude());
        int zoom = 17;

        _map.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, zoom));
        _map.addMarker(new MarkerOptions()
                .title(zona.getName())
                .snippet("N. Máquinas disponibles: " + zona.getMaquinas().size())
                .position(ubicacion));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        _map = googleMap;
        ponerPunto(zonasMusculacion.get(0));
    }
}
