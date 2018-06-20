package prCPI;

public class CPI {
    private double x, y, z, t;

    //public CPI(){
    //    x = y = z = t = 0;
    //}

    public void entra(double valor){
        t = z;
        z = y;
        y = x;
        x = valor;
    }

    public void suma(){
        x = y + x;
        y = z;
        z = t;
    }

    public void resta(){
        x = y - x;
        y = z;
        z = t;
    }

    public void multiplica() {
        x = y * x;
        y = z;
        z = t;
    }

    public void divide() {
        x = y / x;
        y = z;
        z = t;
    }

    public double getResultado() { return x; }

    @Override
    public String toString() {
        return "CPI(x = " + x + " y = " + y + " z = " + z + " t = " + t + ")";
    }
}
