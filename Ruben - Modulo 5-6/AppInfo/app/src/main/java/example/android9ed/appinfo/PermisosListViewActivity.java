package example.android9ed.appinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PermisosListViewActivity extends AppCompatActivity {
    ListView lv;
    TextView descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permisos_list_view);

        lv = findViewById(R.id.listview);
        descripcion = findViewById(R.id.descripciontxt);

        ArrayList<Permisos> listaPermisos = (ArrayList<Permisos>) getIntent().getSerializableExtra("Lista");
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.item, listaPermisos);
        adapter.setDropDownViewResource(R.layout.item);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                descripcion.setText(((Permisos)parent.getItemAtPosition(position)).getDescripcion());
            }
        });
    }
}
