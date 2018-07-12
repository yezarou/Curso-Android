package es.uma.muii.apdm.basicjni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private int privateInt = 35;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void logFromJava(int i) {
        Log.d("HookJava", "logFromJava method has been called with i = " + i);
    }

    private native int nativeFunction1(int in);

    private native float nativeFunction2(float in);

    private native void nativeFunction3();

    private native String nativeFunction4(String str);

    private native int[] nativeFunction5(int[] arr, int size);

    static {
        System.loadLibrary("basicjni");
    }

    public void button1Click(View v) {
        Log.d("HookJava", "Calling nativeFunction1 from Java code ...");
        int i = 5;
        int j = nativeFunction1(i);
        Log.d("HookJava", "Java call nativeFunction1(" + i + ") = " + j);
    }

    public void button2Click(View v) {
        Log.d("HookJava", "Calling nativeFunction2 from Java code ...");
        float f = 6.74f;
        float g = nativeFunction2(f);
        Log.d("HookJava", "Java call nativeFunction2(" + f + ") = " + g);
    }

    public void button3Click(View v) {
        Log.d("HookJava", "Calling nativeFunction3 from Java code ...");
        nativeFunction3();
    }

    public void button4Click(View v) {
        Log.d("HookJava", "Calling nativeFunction4 from Java code ...");
        String strIn = "Hello from Java";
        String str = nativeFunction4(strIn);
        Log.d("HookJava", "Java call nativeFunction4(\"" + strIn + "\") = \"" + str + "\"");
    }

    public void button5Click(View v) {
        Log.d("HookJava", "Calling nativeFunction5 from Java code ...");
        Log.d("HookJava", "Input array before call");
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++)
            Log.d("HookJava", "array[" + i + "] = " + arr[i]);
        int[] out = nativeFunction5(arr, arr.length);
        Log.d("HookJava", "Input array after call");
        for (int i = 0; i < arr.length; i++)
            Log.d("HookJava", "array[" + i + "] = " + arr[i]);
        Log.d("HookJava", "Output array");
        for (int i = 0; i < out.length; i++)
            Log.d("HookJava", "array[" + i + "] = " + out[i]);
    }
}