import Jarras.Jarra;

public class PruebaJarras {
    public static void main(String[] args) {
        Jarra j1 = new Jarra(7);
        Jarra j2 = new Jarra(5);

        j2.llena();
        j1.llenaDesde(j2);
        j2.llena();
        j1.llenaDesde(j2);
        j1.vacia();
        j1.llenaDesde(j2);
        j2.llena();
        j1.llenaDesde(j2);

        System.out.println(j1.toString() + j2.toString());
    }
}
