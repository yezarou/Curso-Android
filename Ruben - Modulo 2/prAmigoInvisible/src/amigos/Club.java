// Rubén Zúñiga García

package amigos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Club {
	protected List<Persona> socios;

	public Club() {
		socios = new ArrayList<>();
	}

	public void leerSocios(String file, String delim) throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(file))) {
			leerSocios(sc, delim);
		}
	}

	public void leerSocios(Scanner sc, String delim)  {
		while (sc.hasNext()) {
			try (Scanner scLinea = new Scanner(sc.next())) {
				scLinea.useDelimiter(delim);
				while (scLinea.hasNext()) {
					crearSocioDesdeString(scLinea.next());
				}
			}
		}
	}

	public void crearSocioDesdeString(String nombreSocio) {
		socios.add(new Persona(nombreSocio));
	}

	public void hacerAmigos() {

		if (socios.size() <= 2) {
			throw new AmigoException("La lista de amigos debe de ser mayor a 2.");
		}

		List<Integer> posAmigos = new ArrayList<>();

		for (int i = 0; i < socios.size(); i++)
			posAmigos.add(i);

		do {
			Collections.shuffle(posAmigos);
		} while (!hayCoincidencias(posAmigos));

		for (int i = 0; i < socios.size(); i++)
			socios.get(i).setAmigo(socios.get(posAmigos.get(i)));
	}

	private static boolean hayCoincidencias(List<Integer> listaBarajada) {
		int i = 0;

		while (i < listaBarajada.size() && listaBarajada.get(i) != i)
			i++;

		return i == listaBarajada.size();
	}

	public void presentarAmigos(String salida) throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(salida)) {
			presentarAmigos(pw);
		}
	}

	public void presentarAmigos(PrintWriter pw) {
		Collections.sort(socios);
		for (Persona p : socios)
			pw.println(p);
	}
}
