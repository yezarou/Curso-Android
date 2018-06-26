import java.io.File;
import java.io.IOException;

public class TestFile {
	public static void main(String[] str) {
		try {// Creación de un fichero en Windows
			File f1 = new File("c:\\POO\\fichero1.txt");
			f1.createNewFile();
			// Creación de un directorio. Se admite el separador de UNIX
			File d1 = new File("c:/POO/carpeta1");
			d1.mkdir();
			// Creación de un directorio y de los directorios intermedios
			File d3 = new File("/POO/carpeta2/carpeta3");
			d3.mkdirs();
			// Creación de un fichero con un directorio File
			File f2 = new File(d3, "fichero2.txt");
			f2.createNewFile();
			// Creación de un fichero a partir de un camino relativo
			File f3 = new File("../fichero3.txt");
			f3.createNewFile();
			// Distintas formas del camino de f3
			System.out.println(f3.getPath());
			System.out.println(f3.getAbsolutePath());
			System.out.println(f3.getCanonicalPath());
			System.out.println(f3.getParent());
			System.out.println(f3.getName());
		} catch (IOException e) {
			System.out.println("ERROR: falló la creación del fichero");
		}
	}
}
