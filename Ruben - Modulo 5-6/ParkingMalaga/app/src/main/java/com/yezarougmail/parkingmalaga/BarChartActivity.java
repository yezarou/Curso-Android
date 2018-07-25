package com.yezarougmail.parkingmalaga;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class BarChartActivity extends AppCompatActivity {
    ArrayList<Parking> list_parking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        ConstraintLayout layout = findViewById(R.id.layout);
        BarChart chart = (BarChart) findViewById(R.id.chart);

        Intent intent = this.getIntent();
        if (intent != null)
            list_parking = (ArrayList<Parking>)intent.getSerializableExtra("ListaParking");

        ArrayList<BarEntry> entries = new ArrayList<>();

        for (int i = 0; i < list_parking.size(); i++){
            Parking parking = list_parking.get(i);
            entries.add(new BarEntry(parking.getCapacidad(), i));
        }

        BarDataSet dataset = new BarDataSet(entries, "# de Capacidad");
        ArrayList<String> labels = new ArrayList<String>();

        for (Parking parking : list_parking)
            labels.add(parking.getNombre());

        BarData data = new BarData(labels, dataset);
        chart.setData(data);
        chart.setDescription("# de parkings de Málaga");
    }
}
