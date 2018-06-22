package stereograma;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FiltroMedia implements FiltroImagen {
    public void filtra(BufferedImage imagen) {
        int fWidth  = imagen.getWidth();
        int fHeight = imagen.getHeight();

        for (int x = 0; x < fWidth ; x++) {
            for (int y = 0; y < fHeight; y++) {
                int red = new Color(imagen.getRGB(x, y)).getRed();
                int green = new Color(imagen.getRGB(x, y)).getGreen();
                int azul = new Color(imagen.getRGB(x, y)).getBlue();
                int media = (red + green + azul) / 3;
                imagen.setRGB(x, y, new Color(media, media, media).getRGB());
            }
        }
    }
}
