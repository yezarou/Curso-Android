/**
 * Created by pacog on 13/4/16.
 */
public class MainOtro {
    public static void main(String[] args) {
        OtroCodigo oc = new OtroCodigo();
        Thread tarea = new Thread(oc, "otro");
        tarea.start();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
        }
        oc.para();

    }
}
