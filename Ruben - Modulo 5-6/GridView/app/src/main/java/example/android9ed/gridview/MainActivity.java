package example.android9ed.gridview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pais> paises;
    GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = findViewById(R.id.gridView);

        String[] nPaises = {"brazil", "canada", "china", "france", "germany", "india", "italy", "japan", "korea", "mexico", "netherlands", "portugal", "spain", "turkey", "united_kingdom", "united_states"};
        paises = new ArrayList<Pais>();

        for (String pais:nPaises){
            Pais p = new Pais(pais, this.getResources().getIdentifier(pais, "drawable", this.getPackageName()));
            paises.add(p);
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, paises);
        ImageAdapter adapterNuevo = new ImageAdapter(this, android.R.layout.simple_list_item_1, paises);
        grid.setAdapter(adapterNuevo);

    }
    public void onClick (View v){
        int numColumn = 0;
        switch (v.getId()){
            case R.id.btn1: numColumn=1; break;
            case R.id.btn2: numColumn=2; break;
            case R.id.btn3: numColumn=3; break;
            case R.id.btn4: numColumn=4; break;
        }

        grid.setNumColumns(numColumn);
    }

    private class ImageAdapter extends BaseAdapter{
        Context ctx;
        int recurso;
        ArrayList lista;

        public ImageAdapter(Context context, int recursoIDLayout, ArrayList datos){
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
                gridElement = inflater.inflate(R.layout.item, null);

            } else { //Reciclado, ya creado
                gridElement = (View) convertView;
            }
            TextView textView = (TextView) gridElement.findViewById(R.id.textViewItem);
            ImageView image = (ImageView)gridElement.findViewById(R.id.imageViewItem);

            Pais pais = (Pais) lista.get(position);
            textView.setText(pais.toString());

            image.setImageResource(pais.getRecursoId());
            return gridElement;


            /*
            ImageView imageView;
            if (convertView == null) { //Nuevo es necesario
                        imageView = new ImageView(ctx);
                imageView.setLayoutParams(new AbsListView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else { //Reciclado, ya creado
                imageView = (ImageView) convertView;
            }
            Pais pais = (Pais) lista.get(position);
            imageView.setImageResource(pais.getRecursoId());
            return imageView;
            */
        }
    }
}
