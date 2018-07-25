package com.yezarougmail.parkingmalaga;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ParkingAdapter extends BaseAdapter {
    Context ctx;
    int recurso;
    ArrayList lista;

    public ParkingAdapter(Context context, int recursoIDLayout, ArrayList datos){
        ctx = context;
        recurso = recursoIDLayout;
        lista = datos;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
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
            gridElement = inflater.inflate(R.layout.parkingitem, null);

        } else { //Reciclado, ya creado
            gridElement = (View) convertView;
        }

        Parking parking = (Parking) lista.get(position);

        TextView txtId = gridElement.findViewById(R.id.text_ID);
        TextView txtNombre = gridElement.findViewById(R.id.text_Nombre);
        txtNombre.setText(parking.getNombre());
        txtId.setText(Integer.toString(parking.getId()));

        return gridElement;
    }
}
