package es.yezarougmail.intentfilter;

import android.Manifest;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.PermissionRequest;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad2 extends AppCompatActivity {

    WebView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 11);

        tv = findViewById(R.id.webView);
        tv.loadUrl(getIntent().getData().toString());


//        Uri data = getIntent().getData();
//        if (data==null){
//            Toast.makeText(this, "Sin datos", Toast.LENGTH_LONG).show();
//        }
//        else{
//            Toast.makeText(this, data.toString(), Toast.LENGTH_LONG).show()
//            ;
//        }
    }
}
