import java.io.*;

public class LeeBufferedFile {
    public static void main(String[] args) throws IOException {
        String fichero = "prTema6/src/personas.txt";
        try (InputStream fs = new FileInputStream(fichero);
             InputStreamReader isr = new InputStreamReader(fs);
             BufferedReader br = new BufferedReader(isr)) {
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
        }
    }
}

