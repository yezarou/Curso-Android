import prJardin.Contador;
import prJardin.Puerta;

public class Main {

	public static void main(String[] args) {
		Contador c = new Contador();
		int iteraciones = 10000;
		Puerta p1 = new Puerta(c, iteraciones);
		Puerta p2 = new Puerta(c, iteraciones);
		Thread thP1 = new Thread(p1);
		Thread thP2 = new Thread(p2);

		long tIni = System.nanoTime();
		thP1.start();
		thP2.start();

		try {
			thP1.join();
			thP2.join();

		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName()
					+ " ha sido interrumpida.");
		}
		System.out.printf("Iteraciones: %,d\n", iteraciones);
		System.out.printf("Contador: %,d\n", c.valor());
		System.out.printf("Diferencia: %,d\n", c.valor() - 2 * iteraciones);
		System.out.printf("Tiempo total %,d\n",
				(System.nanoTime() - tIni) / 1000);
	}
}
