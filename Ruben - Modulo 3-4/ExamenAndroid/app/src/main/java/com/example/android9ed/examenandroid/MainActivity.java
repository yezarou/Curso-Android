package com.example.android9ed.examenandroid;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    float [] A;
    float [] B;
    float [] C;

    long tInicial;
    int array_size;

    EditText etArray;
    Button btnInit;
    Button btnCompute;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInit = (Button) findViewById(R.id.buttonInit);
        btnCompute = (Button) findViewById(R.id.buttonComp);

        btnInit.setOnClickListener(this);
        btnCompute.setOnClickListener(this);

        if (savedInstanceState != null){
            ((TextView) findViewById(R.id.textViewResult)).setText(savedInstanceState.getString("Tiempo"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Tiempo", ((TextView) findViewById(R.id.textViewResult)).getText().toString());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

    public native void productoVectorialCPP( float [] A, float [] B, float [] C, int size);
    public native void productoVectorialCPPThreads( float [] A, float [] B, float [] C, int size, int nThreads);

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonInit:
                inicializarArray();
                break;
            case R.id.buttonComp:
                if (A == null || B == null || C == null)
                    Toast.makeText(this, "Not initialized Arrays.", Toast.LENGTH_SHORT).show();
                else if (((EditText)findViewById(R.id.editTextNth)).getText().toString().equals(""))
                    Toast.makeText(getBaseContext(), "Invalid number of threads.", Toast.LENGTH_SHORT).show();
                else {
                    tInicial = System.nanoTime();
                    new myAsyncTask().execute();
                }
                break;
        }
    }

    private void inicializarArray(){
        etArray = ((EditText) findViewById(R.id.editTextSize));

        if (!etArray.getText().toString().matches("[0-9]+"))
            Toast.makeText(this, "Invalid array_size.", Toast.LENGTH_LONG).show();
        else {
            array_size = Integer.parseInt(etArray.getText().toString());
            A = new float[array_size];
            B = new float[array_size];
            C = new float[array_size];

            Random rand = new Random();
            for (int i = 0; i < array_size; i++){
                A[i] = (float) (rand.nextInt(200)/100) - 1;
                B[i] = (float) (rand.nextInt(200)/100) - 1;
            }
        }
    }

    private void productoVectorial() {
        for (int i = 0; i < array_size; i++)
            C[i] = A[i] * B[i];
    }

    private void productoVectorial(int myId, int nTasks) {
        int inicio = (myId * array_size) / nTasks;
        int fin = ((myId + 1) * array_size)/nTasks;

        for (int i = inicio; i < fin; i++)
            C[i] = A[i] * B[i];
    }

    class myAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            if (((CheckBox) findViewById(R.id.checkBoxNative)).isChecked()) {
                if (((CheckBox) findViewById(R.id.checkBoxPar)).isChecked()) {
                    Log.d("Calculo", "Nativo en paralelo");
                    productoVectorialCPPThreads(A, B, C, array_size, Integer.parseInt(((EditText) findViewById(R.id.editTextNth)).getText().toString()));
                } else {
                    Log.d("Calculo", "Nativo");
                    productoVectorialCPP(A, B, C, array_size);
                }
            } else {
                if (((CheckBox) findViewById(R.id.checkBoxPar)).isChecked()) {
                    Log.d("Calculo", "En paralelo");
                    ejecutarExecutor();
                } else {
                    Log.d("Calculo", "Método");
                    productoVectorial();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void avoids) {
            super.onPostExecute(avoids);

            long tFinal = System.nanoTime();

            ((TextView) findViewById(R.id.textViewResult)).setText(Double.toString(((tFinal - tInicial) / 1000000d)));
        }
    }

    private void ejecutarExecutor(){
        int numTask = Integer.parseInt(((EditText)findViewById(R.id.editTextNth)).getText().toString());
        ExecutorService executor = Executors.newFixedThreadPool(numTask);

        for (int i = 0; i < numTask; i++) {
            executor.execute(new myTask(i, numTask));
        }
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public class myTask implements Runnable{
        private int myId;
        private int nTasks;
        myTask(int _myId, int _nTasks) { myId = _myId; nTasks=_nTasks;}

        @Override
        public void run() {
            productoVectorial(myId, nTasks);
        }
    }
}
