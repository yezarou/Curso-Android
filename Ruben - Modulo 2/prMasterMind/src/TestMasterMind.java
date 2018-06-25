import java.util.Scanner;

import prMasterMind.MasterMindException;
import prMasterMind.MasterMind;
import prMasterMind.MasterMindMemoria;
import prMasterMind.Movimiento;

public class TestMasterMind {

	public static void main(String[] args) throws MasterMindException {
//		MasterMind juego = new MasterMind();
		MasterMindMemoria juego = new MasterMindMemoria();
		
//		System.out.println(juego.secreto());
		try (Scanner sc = new Scanner(System.in)) {
			boolean acertado = false;
			String cifras = null;
			int intento = 1;
			while (!acertado) {
				try {
					System.out.print("Intento " + intento
							+ ". Introduce cifra: ");
					cifras = sc.next();
					Movimiento mov = juego.intento(cifras);
					System.out.println("Intento " + intento + " " + mov);
					acertado = mov.colocadas() == juego.longitud();
					intento++;
				} catch (MasterMindException e) {
					System.out.println(cifras + " no validas: "
							+ e.getMessage());
				}
			}
			System.out.println("Correcto en " + (intento - 1) + " intentos");
//			System.out.println("Movimientos :" + Arrays.toString(juego.movimientos()));
		}
	}
}
