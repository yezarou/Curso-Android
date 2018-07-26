package com.example.joseamontenegromontes.musculacionmalaga;

import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    //IDS
    final static String LISTA_ZONAS = "Lista_Zonas";
    final static String LISTA_MAQUINAS = "Lista_Maquinas";

    //ZONA CSV
    final int  GEO = 2;
    final int  ID_ZONA_MUSCULACION=14;
    final int  Nombre_ZONA_MUSCULACION =15;
    final int  UBICACION=16;
    final int  FOTO_ZONA=17;

    //MAQUINA CSV
    final int Id_Maquina = 18;
    final int Nombre_Maquina = 19;
    final int Nivel = 20;
    final int Icono = 21;
    final int Funcion = 22;
    final int Desarrollo =23;
    final int Precauciones = 24;

    ArrayList<ZonaMusculacion> zonasMusculacion ;
    ArrayList<Maquina> maquinas;

    // URL CSV
    String csv = "http://datosabiertos.malaga.eu/recursos/deportes/maquinasmusculacion/maquinasmusculacion-4326.csv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         zonasMusculacion = new ArrayList<ZonaMusculacion>();
         maquinas = new ArrayList<Maquina>();

         new readCSV().execute();
    }

    /*
      OnClick
     */

    public void onClick(View v){


        switch (v.getId()){

            case R.id.imageButtonZonas:
                       //ToDo: ir Map Activity
                Intent actividad = new Intent(this, MapActivity.class);
                actividad.putExtra(this.LISTA_ZONAS, zonasMusculacion);
                startActivity(actividad);
                            break;
            case R.id.imageButtonMaquinas:
                Intent actividad2 = new Intent(this, MaquinasActivity.class);
                actividad2.putExtra(this.LISTA_MAQUINAS, maquinas);
                startActivity(actividad2);
                break;
            case R.id.imageButtonDownload:
                new readCSV().execute();
                        break;
        }


    }


    // Funcion para pasar las url a resource ID.

    private int urlToResource (String url){

        int barra = url.lastIndexOf('/');
        int point = url.lastIndexOf('.');

        String file = url.substring(barra+1,point);

        Resources resource = getResources();
        String packageName = getPackageName();
        int resourceID = resource.getIdentifier(file,"drawable",packageName);

        return resourceID;

    }




    private class readCSV extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void ... voids) {
            URL stockURL = null;
            try {
                stockURL = new URL(csv);
                BufferedReader in = new BufferedReader(new InputStreamReader(stockURL.openStream()));
                CSVReader reader = new CSVReader(in);
                leerCSV(reader);
            } catch (Exception e) {Log.d("ERROR: " , e.getMessage().toString());}
            return null;
        }

        public void leerCSV(CSVReader reader){

            zonasMusculacion = new ArrayList<ZonaMusculacion>();
            maquinas = new ArrayList<Maquina>();

            String [] nextLine=null;

            boolean cabecera = true;

            try {
                while ((nextLine = reader.readNext()) != null) {
                    if (cabecera) cabecera=false;

                    else{
                        Maquina maquina = new Maquina(Integer.parseInt(nextLine[Id_Maquina]));
                        ZonaMusculacion zona = new ZonaMusculacion(Integer.parseInt(nextLine[ID_ZONA_MUSCULACION]));

                        if (!zonasMusculacion.contains(zona)){
                            zona.setNombre(nextLine[Nombre_ZONA_MUSCULACION]);
                            zona.setLatLng(nextLine[GEO]);
                            zona.setDescripcionUbicacion(nextLine[UBICACION]);
                            zona.setResourceFoto(urlToResource(nextLine[FOTO_ZONA]));
                            zonasMusculacion.add(zona);
                        } else
                            zona = zonasMusculacion.get(zonasMusculacion.indexOf(zona));

                        if (!maquinas.contains(maquina)){
                            maquina.setNombreMaquina(nextLine[Nombre_Maquina]);
                            maquina.setNivel(Integer.parseInt(nextLine[Nivel]));
                            maquina.setResourceFoto(urlToResource(nextLine[Icono]));
                            maquina.setFuncion(nextLine[Funcion]);
                            maquina.setDesarrollo(nextLine[Desarrollo]);
                            maquina.setPrecauciones(nextLine[Precauciones]);
                            maquinas.add(maquina);
                        } else
                            maquina = maquinas.get(maquinas.indexOf(maquina));

                        zona.addMaquina(maquina.getId());
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            for (ZonaMusculacion zona:zonasMusculacion){
                Log.d("Zona",zona.toString());
            }

            for (Maquina maquina:maquinas){
                Log.d("Maquina",maquina.toString());
            }

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            ((TextView) findViewById(R.id.textViewActualizacion)).setText("Ultima actualización: " + new Date());
        }
    }


}
