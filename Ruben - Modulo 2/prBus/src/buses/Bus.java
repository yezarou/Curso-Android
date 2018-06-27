package buses;

public class Bus implements Comparable<Bus> {
    private int codBus;
    private int codLinea;
    private String matricula;

    public Bus(int codbus, String matricula){
        this.codBus = codbus;
        this.matricula = matricula;
    }

    public int getCodBus() {
        return codBus;
    }

    public int getCodLinea() {
        return codLinea;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setCodLinea(int codLinea) {
        this.codLinea = codLinea;
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = obj instanceof Bus;
        Bus bus = res ? (Bus) obj : null;
        return res && codBus == bus.codBus && matricula.equalsIgnoreCase(bus.matricula);
    }

    @Override
    public int hashCode() {
        return matricula.toUpperCase().hashCode() + Integer.hashCode(codBus);
    }

    @Override
    public String toString() {
        return "Bus (" + codBus + ", " + matricula + ", " + codLinea + ")";
    }

    @Override
    public int compareTo(Bus bus) {
        //return Integer.compare(codBus, bus.codBus);
        int res = Integer.compare(codLinea, bus.codLinea);
        if (res == 0)
            res = matricula.compareTo(bus.matricula);

        return res;
    }
}
