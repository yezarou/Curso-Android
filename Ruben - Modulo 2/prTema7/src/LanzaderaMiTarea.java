public class LanzaderaMiTarea {
	static public void main(String[] args) {
		Thread t1 = new MiTarea(1000, "A");
		Thread t2 = new MiTarea(1000, "B");
		t1.start();
		t2.start();
		for (int i = 0; i < 1000; i++) {
			System.out.println("Ruido " + i);
		}
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
		}
		System.out.println("Fin");
	}
}

