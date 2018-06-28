import java.util.StringTokenizer;

public class MainMiCodigo {
	public static void main(String [] args) {
		Thread tarea1 = new Thread(new MiCodigo(1000),"A");
		Thread tarea2 = new Thread(new MiCodigo(1000),"B");
		tarea1.start();
		tarea2.start();
		try {
			tarea1.join();
			tarea2.join();
		} catch (InterruptedException e) {			
		}
		System.out.println("Fin");
	}
}


