package buses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Servicio {
    private List<Bus> buses;
    private String ciudad;

    public Servicio(String ciudad){
        this.ciudad = ciudad;
        buses = new ArrayList<Bus>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void leeBuses(String file) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(file))) {
            while (sc.hasNextLine()) {
                leeBuses(sc);
            }
        }
    }

    public void leeBuses (Scanner sc) {
        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            try (Scanner scBus = new Scanner(linea)) {
                scBus.useDelimiter(",");
                int codBus = scBus.nextInt();
                String matricula = scBus.next();
                Bus bus = new Bus(codBus, matricula);
                bus.setCodLinea(scBus.nextInt());
                buses.add(bus);
            }
            catch (InputMismatchException e) {
                System.err.println("ERROR: Datos incorrectos en linea " + linea);
            }
            catch (NoSuchElementException e) {
                System.err.println("ERROR: Faltan datos en linea " + linea);
            }
        }
    }

    public void agregaBuses(Scanner sc){
    }

    public Set<Bus> filtra (Criterio criterio, Comparator<Bus> comparador){
        Set<Bus> res = new TreeSet<>(comparador);

        for (Bus bus : buses) {
            if (criterio.esSeleccionable(bus))
                res.add(bus);
        }

        return res;
    }

    public void guarda(String file, Criterio criterio, Comparator<Bus> comparador) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(file)) {
            guarda(pw, criterio, comparador);
        }
    }

    public void guarda(PrintWriter pw, Criterio criterio, Comparator<Bus> comparador){
        Set<Bus> sel = filtra(criterio, comparador);
        for (Bus bus : sel)
            pw.println(bus.toString());
        pw.close();
    }
}
