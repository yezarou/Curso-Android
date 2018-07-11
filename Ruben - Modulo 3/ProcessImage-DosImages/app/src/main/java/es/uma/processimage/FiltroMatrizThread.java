package es.uma.processimage;

import android.graphics.Bitmap;
import android.graphics.Color;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FiltroMatrizThread implements FiltroImagen {
    private int dimension;
    private float[] mascara;

    public FiltroMatrizThread(int d, float[] mas) {
        dimension = d;
        mascara = mas;
    }

    public int pixelgris(Bitmap b, int x, int y){
        int pixel = b.getPixel(x, y);
        return (Color.red(pixel) + Color.green(pixel) + Color.blue(pixel))/3;
    }

    public void filtra(Bitmap image) {
        int nThreads = Thread.activeCount();
        int numtasks = nThreads;
        Thread[] threads = new Thread[nThreads];
        int count = 0;

        while (count < numtasks) {
            // Se van ha crear tantos threads como tareas especificadas pero en tandas de nThreads cada vez
            int nth = 0;
            while (nth < nThreads && count < numtasks) {
                // se crean nThreads y se ponen a trabajar (start)
                threads[nth] = new Thread(new myTask(count, numtasks, image));
                threads[nth].start();
                nth++;
                count++;
            }
            for (int i = 0; i < nth; i++) {
                // se espera a que terminen los nThreads que estan trabajando antes de crear otros
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static FiltroMatrizThread creaFiltroMedia() {
        float[] mascara =
                {1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f,
                        1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f,
                        1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f};

        return new FiltroMatrizThread(3, mascara);
    }

    public static FiltroMatrizThread creaFiltroBordes() {
        float[] mascara = {-1.0f, -1.0f , -1.0f ,
                -1.0f ,  8.0f, -1.0f ,
                -1.0f , -1.0f , -1.0f};
        return new FiltroMatrizThread(3, mascara);
    }

    public static FiltroMatrizThread creaFiltroEnfoque() {
        float[] mascara = {0f, -1.0f , 0f ,
                -1.0f ,  5.0f, -1.0f ,
                0f , -1.0f , 0f};
        return new FiltroMatrizThread(3, mascara);
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
