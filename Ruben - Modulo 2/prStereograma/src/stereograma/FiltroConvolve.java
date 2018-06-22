package stereograma;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class FiltroConvolve implements FiltroImagen {
    private float[] mascara;
    private int dimension = 3;

    public FiltroConvolve(int d, float[] m){
        mascara = m;
        dimension = d;
    }

    @Override
    public void filtra(BufferedImage image) {
        Kernel kernel = new Kernel(dimension, dimension, mascara);
//        BufferedImage convolvedImage = new BufferedImage(image.getWidth(),image.getHeight(), image.getType());
        BufferedImageOp bright = new ConvolveOp(kernel);
        BufferedImage convolvedImage = bright.filter(image, null);
//		bright.filter(image, convolvedImage);
        image.getGraphics().drawImage(convolvedImage, 0, 0, null);
    }

    public static FiltroImagen creaFiltroSuavizado() {
        float[] mascara_suavizado = {1.0f/9.0f, 1.0f/9.0f, 1.0f/9.0f,
                1.0f/9.0f, 1.0f/9.0f, 1.0f/9.0f,
                1.0f/9.0f, 1.0f/9.0f, 1.0f/9.0f};
        int dimension = 3;

        return new FiltroConvolve(dimension, mascara_suavizado);
    }

    public static FiltroConvolve creaFiltroBordes() {
        float[] mascara_bordes = {-1.0f, -1.0f, -1.0f,
                                  -1.0f, 9.0f, -1.0f,
                                  -1.0f, -1.0f, -1.0f};
        int dimension = 3;

        return new FiltroConvolve(dimension, mascara_bordes);
    }
}
