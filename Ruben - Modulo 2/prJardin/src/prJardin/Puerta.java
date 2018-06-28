package prJardin;

public class Puerta implements Runnable {
	private Contador contador;
	private int visitas;

	public Puerta(Contador c, int v) {
		this.contador = c;
		this.visitas = v;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()
				+ " arranca con visitas = " + visitas);
		for (int i = 0; i < visitas; i++) {
			contador.incrementa();
		}
	}
}
