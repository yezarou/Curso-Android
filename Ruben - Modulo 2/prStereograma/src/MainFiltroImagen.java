import stereograma.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class MainFiltroImagen {
    public static void main(String [] args)  {
        try {
            FiltroImagen st = FiltroConvolve.creaFiltroBordes();
            BufferedImage imagen = ImageIO.read(new File("prStereograma/espetos.JPG"));
            st.filtra(imagen);
            ImageIO.write(imagen, "jpg", new File("prStereograma/espetosST.JPG"));
        } catch (IOException e) {
            System.err.println("Problema de I/O :" + e.getMessage());
        }
    }
}
