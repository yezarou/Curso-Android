package example.android9ed.gridviewphp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class ActividadDos extends AppCompatActivity {
    int img;
    GridView grd;
    public static ArrayList<Bitmap> imagenes = new ArrayList<Bitmap>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_dos);

        grd = findViewById(R.id.gridView);
        Intent intent =  getIntent();

        if (intent != null){
            img = intent.getIntExtra("imagen", 0);
            DescargaImagen asyncTask = new DescargaImagen();
            asyncTask.execute("http://192.168.96.1:8080/images.php?n=" + img);
        }
        ImageAdapter adaptador = new ImageAdapter(this, R.layout.item, imagenes);
        grd.setAdapter(adaptador);
    }
    public class ImageAdapter extends BaseAdapter {

        Context ctx;
        int resource;
        ArrayList lista;

        public ImageAdapter(Context _ctx, int _resource, ArrayList _lista){
            ctx = _ctx;
            resource = _resource;
            lista = _lista;
        }

        @Override
        public int getCount() {
            return lista.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView img;

            if (convertView == null) { //Nuevo es necesario
                img = new ImageView(ctx);
                img.setLayoutParams(new AbsListView.LayoutParams(85, 85));
                img.setScaleType(ImageView.ScaleType.CENTER_CROP);
                img.setPadding(8, 8, 8, 8);
            } else { //Reciclado, ya creado
                img = (ImageView) convertView;
            }
            img.setImageBitmap((Bitmap)lista.get(position));
            return img;
        }
    }
    public class DescargaImagen extends AsyncTask<String, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bm = null;
            try {
                URL url = new URL(strings[0]); //http://192.168.0.160:8080/image.php?n=2
                Log.d("URL", url.toString());
                InputStream is = url.openStream();
                bm = BitmapFactory.decodeStream(is);
            } catch (IOException e) {
                Log.d("ERROR", e.getMessage());
            }

            return bm;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imagenes.add(bitmap);
            super.onPostExecute(bitmap);
        }
    }
}
