import prUrna.Urna;

public class PruebaUrna {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[0]);

        Urna u = new Urna(7, 5);

        while (u.totalBolas() > 1) {
            Urna.ColorBola b1 = u.extraerBola();
            Urna.ColorBola b2 = u.extraerBola();
            if (b1 == b2) {
                u.ponerBlanca();
            } else {
                u.ponerNegras();
            }
        }
        System.out.println(u.extraerBola());
    }
}
