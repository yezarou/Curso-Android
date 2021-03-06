package es.uma.processimage;

import android.graphics.Bitmap;
import android.graphics.Color;


public class FiltroAzulPorRojo implements FiltroImagen {

	public void filtra(Bitmap imagen) {
		int fWidth  = imagen.getWidth();
		int fHeight = imagen.getHeight();
		
		for (int x = 0; x < fWidth ; x++) {
			for (int y = 0; y < fHeight; y++) {
				int rojo = Color.red(imagen.getPixel(x,y));
				int verde = Color.green(imagen.getPixel(x,y));
				int azul = Color.blue(imagen.getPixel(x,y));
                imagen.setPixel(x, y, Color.rgb(azul,verde,rojo));
			}
		}
	}
}
