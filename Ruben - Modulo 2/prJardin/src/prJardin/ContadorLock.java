package prJardin;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ContadorLock {
	private int contador;
	// private final Lock lock_c = new ReentrantLock();
	

	public ContadorLock() {
		this.contador = 0;
	}

	public int valor() {
		return contador;
	}

	public  void incrementa() {
		// lock_c.lock();
		contador++;	
		// lock_c.unlock();
	}

}
