import buses.*;

import java.io.FileNotFoundException;
import java.util.Comparator;

public class MainBuses {
    public static void main(String[] args) {
        Servicio servicio = new Servicio("Málaga");

        try {
            servicio.leeBuses("prBus/src/buses.txt");
        } catch (FileNotFoundException e){
            System.err.println("Fichero no encontrado " + e.getMessage());
        }

        for (Bus bus : servicio.filtra(p -> p.getCodLinea() == 2, new ArbitroCodLinea())) {
            System.out.println(bus);
        }

        Comparator<Bus> cb = new ArbitroCodLinea().thenComparing(new ArbitroCodBus());

        try {

            servicio.guarda("prBus/src/filtro.txt", p -> p.getCodLinea() == 2, new ArbitroCodLinea());
        }
        catch (FileNotFoundException e){
            System.out.println("No");
        }
    }
}
