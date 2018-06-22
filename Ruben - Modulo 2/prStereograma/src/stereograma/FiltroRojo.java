package stereograma;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FiltroRojo implements FiltroImagen {
	
	public void filtra(BufferedImage imagen) {
		int fWidth  = imagen.getWidth();
		int fHeight = imagen.getHeight();
		
		for (int x = 0; x < fWidth ; x++) {
			for (int y = 0; y < fHeight; y++) {
				int rojo = new Color(imagen.getRGB(x, y)).getRed();
				imagen.setRGB(x, y, new Color(rojo,0,0).getRGB());
			}
		}
	}
}
