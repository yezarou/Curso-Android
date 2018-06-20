public class Main {
    public static void main(String[] args) {
        Punto p = new Punto();
        Punto q = new Punto(3,4);
        System.out.println(p.distancia(q));

        p = new Punto(9,12);
        System.out.println(p.distancia(q));
        System.out.println(p);
    }
}
