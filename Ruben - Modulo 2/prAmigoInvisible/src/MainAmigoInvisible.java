// Rubén Zúñiga García

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import amigos.AmigoException;
import amigos.Club;
import amigos.ClubParejas;

public class MainAmigoInvisible {
	public static void main(String [] args) throws IOException {
		try {
			// Usar estas dos líneas para probar Club
			Club club = new Club();
			club.leerSocios("prAmigoInvisible/socios.txt", "[ ,;-]+");

			// Usar estas dos líneas para probar ClubParejas
//			Club club = new ClubParejas();
//          club.leerSocios("prAmigoInvisible/socios.txt", "[ ,;]+");

			club.hacerAmigos();
			// Se guarda en un fichero
			club.presentarAmigos("prAmigoInvisible/salida.txt");
			// Se presenta en consola
			PrintWriter pw = new PrintWriter(System.out, true);
			club.presentarAmigos(pw);
		} catch (FileNotFoundException e) {
			System.err.println("Error de E/S: " + e.getMessage());
		} catch (AmigoException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
