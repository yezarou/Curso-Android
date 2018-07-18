package es.yezarougmail.intentfilter;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!Intent.ACTION_MAIN.equals(getIntent().getAction()) ){
            Uri data=getIntent().getData();
            if (data==null){
                Toast.makeText(this, "Sin datos", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this, data.toString(), Toast.LENGTH_LONG).show()
                ;
            }
        }
    }

    public void ViewFiltro (View V){

        String link="http://www.marca.com/tenis.html";
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(link));

        PackageManager pm = getPackageManager();
        List<ResolveInfo> infoList = pm.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        int num = infoList.size();
        Log.d("Intent", "Hemos encontrado: " + num);
        for (int i = 0; i < num; i++)
            Log.d("Intent", infoList.get(i).activityInfo.name);

        if (num > 0)
            startActivity(intent);
    }


    public void ViewNoFiltro (View V){

        String link="http://www.uma.es";
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
        startActivity(intent);
    }

}
