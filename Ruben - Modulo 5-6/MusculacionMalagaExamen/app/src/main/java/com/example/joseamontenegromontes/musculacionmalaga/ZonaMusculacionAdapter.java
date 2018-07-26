package com.example.joseamontenegromontes.musculacionmalaga;


import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ZonaMusculacionAdapter extends BaseAdapter {

    Context ctx;
    int layout;
    ArrayList<ZonaMusculacion> datos;

    public ZonaMusculacionAdapter(Context _ctx, int _layout, ArrayList<ZonaMusculacion> _datos){
        ctx = _ctx;
        layout = _layout;
        datos = _datos;
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridElement=null;
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) { //Nuevo es necesario
            gridElement = inflater.inflate(R.layout.zona_layout, null);

        } else { //Reciclado, ya creado
            gridElement = (View) convertView;
        }

        ZonaMusculacion zonaMusculacion = (ZonaMusculacion) datos.get(position);
        ImageView imagen = gridElement.findViewById(R.id.imageViewZonaMusculacion);
        TextView nombre = gridElement.findViewById(R.id.textViewZonaMusculacion);
        TextView descripcion = gridElement.findViewById(R.id.textViewDescripcion);
        TextView maquinas = gridElement.findViewById(R.id.textViewMaquinas);

        imagen.setImageResource(zonaMusculacion.getResourceFoto());
        nombre.setText(zonaMusculacion.getName());
        descripcion.setText(zonaMusculacion.getDescripcionUbicacion());
        maquinas.setText("Num. Máquinas: " + zonaMusculacion.getMaquinas().size());

        return gridElement;
    }
}