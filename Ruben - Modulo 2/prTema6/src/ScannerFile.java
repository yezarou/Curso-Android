/**
 * Created by pacog on 15/4/15.
 */
import java.io.*;
import java.util.*;
public class ScannerFile {
    public static void main(String[] args) {
        // leer el fichero de palabras y mostrarlas en pantalla línea a línea
        try (Scanner sc = new Scanner(new File(args[0]))) {
            int linea = 1;
            while (sc.hasNextLine()) {
                System.out.println(linea + "\t:"+ sc.nextLine());
                linea++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: falta el nombre del fichero");
        } catch (IOException e) {
            System.out.println("ERROR: no se puede leer del fichero");
        }
    }
}
