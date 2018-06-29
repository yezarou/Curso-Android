import musculacion.Maquina;
import musculacion.Musculacion;
import musculacion.Zona;

import java.io.IOException;

public class MainMusculacion {
    static final String urlDatosMalaga = "http://datosabiertos.malaga.eu/recursos/deportes/maquinasmusculacion/maquinasmusculacion-4326.csv";
    static final String localDatosMalaga = "prZonaMusculacion/zonasMusculacion-4326.csv";

    public static void main(String [] args) {
        Musculacion musculacion = new Musculacion("Málaga");
        try {
            // Poner comentario solo a una de las dos lineas siguientes
      //      musculacion.leeDatosUrl(urlDatosMalaga);
            musculacion.leeDatosLocal(localDatosMalaga);
            System.out.println("Las zonas de Musculación de " + musculacion.getCiudad());
            for (Zona zm : musculacion.getZonas()) {
                System.out.println(zm);
                for (Maquina mq : zm.getMaquinas()) {
                    System.out.println("\t" + mq);
                }
            }

            System.out.println("\nLas máquinas de la zona 100");
            for (Maquina mq : musculacion.getMaquinasEnZonaId(100)) {
                System.out.println(mq);
            }

            System.out.println("\nLas zonas con la máquina 27");
            for (Zona zm : musculacion.getZonasConMaquinaId(27)) {
                System.out.println(zm);
            }
        } catch (IOException e) {
            System.out.println("Error I/O: " + e.getMessage());
        }
    }
}
