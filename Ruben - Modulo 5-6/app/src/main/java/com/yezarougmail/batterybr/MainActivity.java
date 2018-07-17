package com.yezarougmail.batterybr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    TextView txt2;
    ReceptorIntentPhone receptor;
    public static int contador = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.bateria);
        txt2 = (TextView) findViewById(R.id.Pantalla);
        receptor = new ReceptorIntentPhone();
        IntentFilter filterCargador = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(receptor, filterCargador);
        filterCargador.addAction(Intent.ACTION_SCREEN_ON);
        filterCargador.addAction(Intent.ACTION_SCREEN_OFF);


        registerReceiver(receptor, filterCargador);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receptor);
    }

    private class ReceptorIntentPhone extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (action.equals(Intent.ACTION_SCREEN_ON)) {
                PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
                Log.d("Pantalla", "Encendida");
                String linea = "Hola que tal";
                txt2.setText(linea.split(" ")[contador%linea.split(" ").length]);
            } else if (action.equals(Intent.ACTION_SCREEN_OFF)) {
                Log.d("Pantalla", "Apagado");
                contador++;
            } else {
                int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
                boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                        status == BatteryManager.BATTERY_STATUS_FULL;
                if (isCharging) {
                    int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
                    boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
                    boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
                    if (usbCharge) txt.setText("Cargando por USB...");
                    if (acCharge) txt.setText("Cargando red Eléctrica...");
                } else txt.setText("No Carga...");
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                String msg = txt.getText().toString();
                msg = msg.concat(" nivel batería " + level);
                txt.setText(msg);
            }
        }

    }
}