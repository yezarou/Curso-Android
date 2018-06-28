class MiCodigo implements Runnable {
	int tope;
	MiCodigo(int t) {
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
