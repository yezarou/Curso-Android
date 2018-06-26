import java.io.*;
public class GuardaPalabras {
    public static void main(String[] args)  {
        // crear un fichero de palabras
        try (PrintWriter pw = new PrintWriter(args[0])) {
            pw.println("amor roma mora ramo");
            pw.println("rima mira");
            pw.println("rail liar");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: falta el nombre del fichero");
        } catch (IOException e) {
            System.out.println("ERROR: no se puede leer del fichero");
        }
    }
}
