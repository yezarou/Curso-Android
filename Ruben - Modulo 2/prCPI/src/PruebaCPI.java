import prCPI.CPI;

public class PruebaCPI {
    public static void main(String[] args) {
        CPI cpi = new CPI();
        cpi.entra(3);
        cpi.entra(6);
        cpi.entra(2);
        cpi.resta();
        cpi.multiplica();
        cpi.entra(5);
        cpi.suma();
        System.out.println("Resultado " + cpi.getResultado ());

        cpi = new CPI();
        cpi.entra(3);
        cpi.entra(6);
        cpi.entra(2);
        cpi.resta();
        cpi.multiplica();
        cpi.entra(2);
        cpi.entra(7);
        cpi.suma();
        cpi.entra(5);
        cpi.divide();
        cpi.suma();
        System.out.println("Resultado " + cpi.getResultado ());
    }
}
