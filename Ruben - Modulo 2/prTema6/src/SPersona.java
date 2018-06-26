import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class SPersona {

    private Set<Persona> personas = new HashSet<>();


    public void leePersonas(String fichero) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(fichero))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                try (Scanner scLinea = new Scanner(linea)) {
                    scLinea.useDelimiter("[,:-]+");
                    String nombre = scLinea.next();
                    int edad = scLinea.nextInt();
                    Persona persona = new Persona(nombre, edad);
                    personas.add(persona);
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("Error de fichero. Número erróneo");
                } catch (NoSuchElementException e) {
                    throw new NoSuchElementException("Error de fichero. Faltan datos");
                }
            }
        }
    }

    public Set<Persona> getPersonas() {
        return personas;
    }
}
