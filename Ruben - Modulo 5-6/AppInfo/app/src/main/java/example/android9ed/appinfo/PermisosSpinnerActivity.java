package example.android9ed.appinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PermisosSpinnerActivity extends AppCompatActivity {
    Spinner sp;
    TextView descripcionPermisos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permisos_spinner);
        sp = findViewById(R.id.spinner);
        descripcionPermisos = findViewById(R.id.txtDescripcion);

        ArrayList<Permisos> listaPermisos = (ArrayList<Permisos>) getIntent().getSerializableExtra("Lista");
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.itemspinner, listaPermisos);
        adapter.setDropDownViewResource(R.layout.itemspinner);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                descripcionPermisos.setText(((Permisos)parent.getItemAtPosition(position)).getDescripcion());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
