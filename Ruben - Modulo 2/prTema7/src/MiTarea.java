class MiTarea extends Thread {
	int tope;

	public MiTarea(int t, String nombre) {
		super(nombre);
		tope = t;
	}

	public void run() {
		int i = 0;
		while (i < tope) {
			System.out.println(Thread.currentThread().getName() + i);
			i++;
		}
	}
}
