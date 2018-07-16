package es.uma.processimage;

import android.graphics.Bitmap;

public class FiltroMatriz implements FiltroImagen {
    private int dimension;
    private float[] mascara;

    public FiltroMatriz(int d, float[] mas) {
        dimension = d;
        mascara = mas;
    }

    public void filtra(Bitmap image) {
    }

    public static FiltroMatriz creaFiltroMedia() {
        float[] mascara =
                {1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f,
                        1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f,
                        1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f};

        return new FiltroMatriz(3, mascara);
    }

    public static FiltroMatriz creaFiltroBordes() {
        float[] mascara = {-1.0f, -1.0f , -1.0f ,
                -1.0f ,  9.0f, -1.0f ,
                -1.0f , -1.0f , -1.0f};
        return new FiltroMatriz(3, mascara);
    }

    public static FiltroMatriz creaFiltroEnfoque() {
        float[] mascara = {0f, -1.0f , 0f ,
                -1.0f ,  5.0f, -1.0f ,
                0f , -1.0f , 0f};
        return new FiltroMatriz(3, mascara);
    }

    public static FiltroMatriz creaFiltroBrillo() {
        float[] mascara = {1.2f};
        return new FiltroMatriz(1, mascara);
    }
}
