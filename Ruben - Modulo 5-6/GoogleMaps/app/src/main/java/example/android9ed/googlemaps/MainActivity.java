package example.android9ed.googlemaps;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap _map;
    ListView locales;
    ArrayList<Local> Locales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locales = (ListView) findViewById(R.id.listview);

        String[][] localesListString = {
                {"-4.089618", "36.742749", "pub", "O' Donnell's"},
                {"-4.420728", "36.722902", "pub", "Morrissey's"},
                {"-4.493384", "36.676734", "pub", "O'Learys Bar"},
                {"-4.420206", "36.719974", "bar", "La Taberna Del Obispo"},
                {"-4.418951", "36.722044", "bar", "Casa Lola"},
                {"-4.430179", "36.710847", "bar", "Universitas Cafe"},
        };

        Locales = new ArrayList<Local>();

        Local temp;
        for (int i = 0; i < localesListString.length; i++) {
            temp = new Local(i, localesListString[i][3]);
            temp.setLongitude(Double.parseDouble(localesListString[i][0]));
            temp.setLatitude(Double.parseDouble(localesListString[i][1]));
            temp.setTipo(localesListString[i][2]);
            Locales.add(temp);
        }

        locales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Toast.makeText(getApplicationContext(), Locales.get(i).getNombre(), Toast.LENGTH_LONG).show();
                setMarker(Locales.get(i));
            }
        });

        LocalAdapter adapter = new LocalAdapter(this, R.layout.item, Locales);
        locales.setAdapter(adapter);
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

    public void onClick(View view) {
        EditText txt = findViewById(R.id.editText);
        LatLng loc;

        try {
            loc = getLocationFromAddress(this, txt.getText().toString());
            ponerMarcador(loc);
        } catch (Exception e) {
        }
    }

    public void ponerMarcador(LatLng loc){
        _map.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 17));
        _map.addMarker(new MarkerOptions()
                .position(loc));
    }

    public LatLng getLocationFromAddress(Context context, String strAddress)
    {
        Geocoder coder= new Geocoder(context);
        List<Address> address;
        LatLng p1 = null;
        try
        {
            address = coder.getFromLocationName(strAddress, 5);
            if(address==null)
            {
                return null;
            }
            Address location = address.get(0);
            p1 = new LatLng(location.getLatitude(), location.getLongitude());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return p1;
    }

    public void setMarker(Local local) {
        _map.clear();
        LatLng marker = new LatLng(local.getLatitude(), local.getLongitude());
        int zoom = 17;
        _map.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, zoom));
        _map.addMarker(new MarkerOptions()
                .title(local.getNombre())
                .position(marker));    }
}
