package com.example.joseamontenegromontes.musculacionmalaga;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MaquinasAdapter extends BaseAdapter {
    Context ctx;
    int layout;
    ArrayList<Maquina> datos;

    public MaquinasAdapter(Context _ctx, int _layout, ArrayList<Maquina> _datos){
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
            gridElement = inflater.inflate(R.layout.maquina_layout, null);

        } else { //Reciclado, ya creado
            gridElement = (View) convertView;
        }
        Maquina maquina = (Maquina) datos.get(position);
        ImageView imagen = gridElement.findViewById(R.id.imageViewMaquina);
        TextView nombre = gridElement.findViewById(R.id.textViewMaquina);
        TextView nivel = gridElement.findViewById(R.id.textViewNivel);
        TextView funcion = gridElement.findViewById(R.id.textViewFuncion);

        imagen.setImageResource(maquina.getIcono());
        nombre.setText(maquina.getNombreMaquina());
        nivel.setText("Nivel: " + maquina.getNivel());
        funcion.setText(maquina.getFuncion());

        return gridElement;
    }
}