/**
 * Created by pacog on 13/4/16.
 */
public class OtroCodigo implements Runnable {
    boolean sigo = true;

    public void run() {
        int i  = 0;
        while (sigo) {
            System.out.println(Thread.currentThread().getName() + i);
            i++;
        }
    }

    public void para() {
        sigo = false;
    }
}
