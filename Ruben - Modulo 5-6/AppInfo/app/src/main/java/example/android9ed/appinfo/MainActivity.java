package example.android9ed.appinfo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnSpinner;
    Button btnListView;
    ArrayList<Permisos> listaPermisos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPermisos = AppUtil.todosPermisos(this);

        btnSpinner = findViewById(R.id.btnSpinner);
        btnListView = findViewById(R.id.btnListView);
    }

    public void onClick (View v){
        Intent ventana = null;

        switch (v.getId()){
            case R.id.btnListView:
                ventana = new Intent(this, PermisosListViewActivity.class);
                break;
            case R.id.btnSpinner:
                ventana = new Intent(this, PermisosSpinnerActivity.class);
                break;
        }
        ventana.putExtra("Lista", listaPermisos);
        startActivity(ventana);
    }

    public List<Permisos> Lista(){
        return listaPermisos;
    }
}
