import alturas.*;

import java.io.FileNotFoundException;

public class MainPaises {
    public static void main(String[] args) {
        Paises paises = new Paises();
        Pais[] paisesFiltrado;

        try {
            paises.leePaises("prAltura/src/alturas.txt");
        } catch (FileNotFoundException e) {
            System.out.println("No existe el fichero.");
        }

        System.out.println("Mayores que 1.77");
        for (Pais p: paises.selecciona(new MayoresQue(1.77))) {
            System.out.println(p);
        }

        System.out.println("Menores que 1.77");
        for (Pais p: paises.selecciona(new MenoresQue(1.77))) {
            System.out.println(p);
        }

        System.out.println("De Europa");
        for (Pais p: paises.selecciona(p -> p.getContinente().equals("Europe"))) {
            System.out.println(p);
        }
    }
}
