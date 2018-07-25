package com.yezarougmail.parkingmalaga;

import android.Manifest;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Parking> list_parking;
    TextView fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fecha = findViewById(R.id.textView2);

        list_parking = new ArrayList<>();
        loadParking();

        fecha.setText(list_parking.get(0).getFechaAct());
    }

    public void onClick(View view){
        Intent intent = null;

        switch (view.getId()){
            case R.id.btnGrafico:
                intent = new Intent(this, BarChartActivity.class);
                break;
            case  R.id.btnLoad:
                AsyncTask cargar = new AsyncTask();
                cargar.execute();
                break;
            case  R.id.btnMaps:
                intent = new Intent(this, MapActivity.class);
                break;
        }

        if (intent != null) {
            intent.putExtra("ListaParking", list_parking);
            startActivity(intent);
        }
    }

    private void load(){
        list_parking.clear();

        String url= "http://datosabiertos.malaga.eu/recursos/aparcamientos/ocupappublicosmun/ocupappublicosmun.csv";
        URL stockURL = null;
        try {
            stockURL = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(stockURL.openStream()));
            CSVReader reader = new CSVReader(in);
            leerCsv(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class AsyncTask extends android.os.AsyncTask<Void, Void, Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            load();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            fecha.setText(list_parking.get(0).getFechaAct());
        }
    }

    private void leerCsv(CSVReader reader) throws IOException {
        String[] nextLine;
        boolean cabecera = true;
        Parking parking;
        while ((nextLine = reader.readNext()) != null) {
            if (cabecera) cabecera = false;
            else {
                parking = new Parking(Integer.parseInt(nextLine[0]), nextLine[1]);
                parking.setDir(nextLine[2]);
                parking.setLatitude(Double.parseDouble(nextLine[5]));
                parking.setLongitude(Double.parseDouble(nextLine[6]));
                String capacidad = nextLine[8];
                parking.setCapacidad(Integer.parseInt(capacidad.equals("None")?"-1":capacidad));
                parking.setFechaAct(nextLine[10]);
                parking.setLibres(Integer.parseInt(nextLine[11]));

                list_parking.add(parking);
            }
        }
    }

    private void loadParking () {
        Parking salitre = new Parking(1, "Salitre");
        Parking cervantes = new Parking(2, "Cervantes");
        Parking elpalo = new Parking(3, "El Palo");
        Parking andalucia = new Parking(4, "Av. de Andalucía");
        Parking camas = new Parking(5, "Camas");
        Parking alcazaba = new Parking(6, "Alcazaba");
        
        salitre.setDir("Calle Salitre");
        salitre.setLatitude(36.7132149);
        salitre.setLongitude(-4.4276681);
        salitre.setCapacidad(342);
        salitre.setFechaAct("25/07/17 16:00");
        salitre.setLibres(308);

        cervantes.setDir("Calle Cervantes");
        cervantes.setLatitude(36.7208633);
        cervantes.setLongitude(-4.4119148);
        cervantes.setCapacidad(414);
        cervantes.setFechaAct("25/07/17 16:00");
        cervantes.setLibres(349);

        elpalo.setDir("Calle Alonso Carrillo De Albornoz");
        elpalo.setLatitude(36.7210350);
        elpalo.setLongitude(-4.3607192);
        elpalo.setCapacidad(129);
        elpalo.setFechaAct("25/07/17 16:00");
        elpalo.setLibres(93);

        andalucia.setDir("Avenida De Andalucía");
        andalucia.setLatitude(36.7171364);
        andalucia.setLongitude(-4.4277549);
        andalucia.setCapacidad(517);
        andalucia.setFechaAct("25/07/17 16:00");
        andalucia.setLibres(495);

        camas.setDir("Calle Camas");
        camas.setLatitude(36.7193031);
        camas.setLongitude(-4.4249320);
        camas.setCapacidad(308);
        camas.setFechaAct("25/07/17 16:00");
        camas.setLibres(232);

        alcazaba.setDir("Plaza La Alcazaba");
        alcazaba.setLatitude(36.7224312);
        alcazaba.setLongitude(-4.4165168);
        alcazaba.setCapacidad(344);
        alcazaba.setFechaAct("25/07/17 16:00");
        alcazaba.setLibres(96);

        list_parking.add(salitre);
        list_parking.add(cervantes);
        list_parking.add(elpalo);
        list_parking.add(andalucia);
        list_parking.add(camas);
        list_parking.add(alcazaba);
    }
}
