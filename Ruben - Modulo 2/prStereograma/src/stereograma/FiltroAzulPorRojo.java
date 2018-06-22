package stereograma;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FiltroAzulPorRojo implements FiltroImagen {
	
	public void filtra(BufferedImage imagen) {
		int fWidth  = imagen.getWidth();
		int fHeight = imagen.getHeight();
		
		for (int x = 0; x < fWidth ; x++) {
			for (int y = 0; y < fHeight; y++) {
				int azul = new Color(imagen.getRGB(x, y)).getBlue();
				int red = new Color(imagen.getRGB(x, y)).getRed();
				imagen.setRGB(x, y, new Color(azul,0,red).getRGB());
			}
		}
	}
}
