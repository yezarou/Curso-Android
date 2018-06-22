package stereograma;

import stereograma.FiltroImagen;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;


public class FiltroSuavizado implements FiltroImagen {
	
    protected float[] mascara_suavizado = {1.0f/9.0f, 1.0f/9.0f, 1.0f/9.0f,
    		                               1.0f/9.0f, 1.0f/9.0f, 1.0f/9.0f, 
    		                               1.0f/9.0f, 1.0f/9.0f, 1.0f/9.0f};
    protected int dimension = 3;
   

    public void filtra(BufferedImage image) {
		Kernel kernel = new Kernel(dimension, dimension, mascara_suavizado);
//        BufferedImage convolvedImage = new BufferedImage(image.getWidth(),image.getHeight(), image.getType());
	    BufferedImageOp bright = new ConvolveOp(kernel);
		BufferedImage convolvedImage = bright.filter(image, null);
//		bright.filter(image, convolvedImage);
	    image.getGraphics().drawImage(convolvedImage,0,0,null);
	}
}
