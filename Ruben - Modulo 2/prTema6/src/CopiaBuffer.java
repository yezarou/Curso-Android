import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiaBuffer {
	public static void main(String args[]) {
		byte [] buffer = new byte[1024];
		try (FileInputStream desdeF = new FileInputStream(args[0]);
				 FileOutputStream hastaF = new FileOutputStream(args[1])) {
			// Copia de los bytes
			int i = desdeF.read(buffer);
			while (i != -1) { // -1 si se alcanza fin de fichero
				hastaF.write(buffer, 0, i);
				i = desdeF.read(buffer);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Uso: Copia <origen> <destino>");
		} catch (FileNotFoundException e) {
			System.err.println("No existe " + e);
		} catch (IOException e) {
			System.err.println("Error de E/S " + e);
		}
	}
}
