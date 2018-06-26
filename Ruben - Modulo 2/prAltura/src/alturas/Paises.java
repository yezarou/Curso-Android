package alturas;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Paises {
    private List<Pais> paises;

    public Paises() {
        paises = new ArrayList<>();
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void leePaises(String file) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(file))) {
            leePaises(sc);
        }
    }

    private void leePaises(Scanner sc) {
        int nPaises = 0;

        while (sc.hasNextLine()) {
            try (Scanner scPais = new Scanner(sc.nextLine()).useLocale(Locale.ENGLISH)) {
                scPais.useDelimiter(",");
                String nombre = scPais.next();
                String continente = scPais.next();
                double altura = scPais.nextDouble();
                paises.add(new Pais(nombre, continente, altura));
            }
        }
    }

    public List<Pais> selecciona(Seleccion sel){
        List<Pais> res = new ArrayList<>();

        for (Pais pais : paises) {
            if (sel.test(pais)){
                res.add(pais);
            }
        }

        return res;
    }
}
