public class LanzaderaMiCodigo {
	   static public void main(String [] args) {
		MiCodigo mc1 = new MiCodigo(1000);
  		Thread   t1  = new Thread(mc1,"A");
		MiCodigo mc2 = new MiCodigo(1000);
  		Thread   t2  = new Thread(mc2,"B");
  		t1.start();
		t2.start();
		for (int i = 0 ; i < 1000; i++) {
		   System.out.println("Ruido "+i);
		}
		try {
		     t1.join();
		     t2.join();
		} catch (InterruptedException e) {
		}
		System.out.println("Fin");
	   }
}
