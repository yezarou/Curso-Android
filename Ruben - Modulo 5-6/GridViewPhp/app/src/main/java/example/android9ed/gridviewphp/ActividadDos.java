package example.android9ed.gridviewphp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class ActividadDos extends AppCompatActivity {
    int img;
    GridView grd;
    public static ArrayList<Bitmap> imagenes = new ArrayList<Bitmap>();
    ArrayList<String> imagenesStr;
    ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_dos);

        imagenesStr = new ArrayList<>();
        grd = findViewById(R.id.gridView);
        Intent intent = getIntent();

        adapter = new ImageAdapter(this);
        grd.setAdapter(adapter);

        if (intent != null) {
            img = intent.getIntExtra("imagen", 0);
            DescargaImagen asyncTask = new DescargaImagen();
            asyncTask.execute("http://192.168.96.1:8080/images.php?n=" + img);
        }
    }
    public class ImageAdapter extends ArrayAdapter<Bitmap> {
        Context contexto;

        public ImageAdapter(Context context) {
            super(context, 0);
            contexto = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ImageView imagen = new ImageView(contexto);

            Bitmap bitmap = getItem(position);
            imagen.setImageBitmap(bitmap);
            return imagen;
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
            imagenes.add(bm);
            return bm;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            for (Bitmap imagen : imagenes)
                adapter.add(imagen);
            super.onPostExecute(bitmap);
        }
    }

    private String crearCadena(){
        String cadena="";

        for(String img : imagenesStr){
            cadena += img;
            cadena += ",";
        }
        cadena.substring(0, cadena.length()-1);

        return cadena;
    }

    private void guardar(){
        SharedPreferences settings = getSharedPreferences("Hola", 0);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString("ListaImagenes", crearCadena());
    }

    private String encode(Bitmap bitmap){
        int quality=100;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, quality, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();

        String encodedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);
        return encodedImage;
    }

    private Bitmap decode(String bitmapStr){
        byte[] decodedString = Base64.decode(bitmapStr, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        return decodedByte;
    }
}
