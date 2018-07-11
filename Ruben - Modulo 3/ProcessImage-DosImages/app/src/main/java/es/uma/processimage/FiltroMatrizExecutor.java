package es.uma.processimage;

import android.graphics.Bitmap;
import android.graphics.Color;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FiltroMatrizExecutor implements FiltroImagen {
    private int dimension;
    private float[] mascara;

    public FiltroMatrizExecutor(int d, float[] mas) {
        dimension = d;
        mascara = mas;
    }

    public int pixelgris(Bitmap b, int x, int y){
        int pixel = b.getPixel(x, y);
        return (Color.red(pixel) + Color.green(pixel) + Color.blue(pixel))/3;
    }

    public void filtra(Bitmap image) {
        int numTask = 20;
        ExecutorService executor = Executors.newFixedThreadPool(Thread.activeCount());
        // se crean todas las tasks indicadas y se mandan a ejecutar en el executor
        for (int i = 0; i < numTask; i++) {
            executor.execute(new myTask(i, numTask, image));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static FiltroMatrizExecutor creaFiltroMedia() {
        float[] mascara =
                {1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f,
                        1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f,
                        1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f};

        return new FiltroMatrizExecutor(3, mascara);
    }

    public static FiltroMatrizExecutor creaFiltroBordes() {
        float[] mascara = {-1.0f, -1.0f , -1.0f ,
                -1.0f ,  8.0f, -1.0f ,
                -1.0f , -1.0f , -1.0f};
        return new FiltroMatrizExecutor(3, mascara);
    }

    public static FiltroMatrizExecutor creaFiltroEnfoque() {
        float[] mascara = {0f, -1.0f , 0f ,
                -1.0f ,  5.0f, -1.0f ,
                0f , -1.0f , 0f};
        return new FiltroMatrizExecutor(3, mascara);
    }

    public void filtraChunk(Bitmap imagen, int myId, int nTask) {
        int width = imagen.getWidth();
        int rango = imagen.getHeight() - 2;
        int fHeightIni = ((myId * rango) / nTask) + 1;
        int fHeightFin = (((myId + 1) * rango) / nTask) + 1;
        float fcolor;
        int color;
        Bitmap oimage = imagen.copy(Bitmap.Config.ARGB_8888,true);

        for(int y=fHeightIni; y < fHeightFin ;y++) {
            for (int x = 1; x < width - 1; x++) {

                fcolor = mascara[0] * pixelgris(oimage, x - 1, y - 1) +
                        mascara[1] * pixelgris(oimage, x - 1, y) +
                        mascara[2] * pixelgris(oimage, x - 1, y + 1) +
                        mascara[3] * pixelgris(oimage, x, y - 1) +
                        mascara[4] * pixelgris(oimage, x, y) +
                        mascara[5] * pixelgris(oimage, x, y + 1) +
                        mascara[6] * pixelgris(oimage, x + 1, y - 1) +
                        mascara[7] * pixelgris(oimage, x + 1, y) +
                        mascara[8] * pixelgris(oimage, x + 1, y + 1);

                color = fcolor > 255 ? 255 : fcolor < 0 ? 0 : Math.round(fcolor);
                // asigna el mismo color en RGB y valor alfa a 1
                imagen.setPixel(x, y, 0xff000000 | (color << 16) | (color << 8) | color);
            }
        }
    }

    public class myTask implements Runnable {
        private int myId;
        private int nTasks;
        private Bitmap img;

        myTask(int _myId, int _nTasks, Bitmap _img) {
            myId = _myId;
            nTasks = _nTasks;
            img = _img;
        }

        @Override
        public void run() {
            filtraChunk(img, myId, nTasks);
        }
    }
}
