// Rubén Zúñiga García

package amigos;

class Pareja {
    private Persona uno, otro;

    public Pareja(Persona u, Persona o) {
        uno = u;
        otro = o;
    }

    @Override
    public String toString() {
        return "(" + uno + "," + otro + ")";
    }

    @Override
    public boolean equals(Object o) {
        boolean res = o instanceof Pareja;
        Pareja p = res ? (Pareja) o : null;
        return res &&
                ((p.uno.equals(uno) && p.otro.equals(otro) ||
                        (p.uno.equals(otro) && p.otro.equals(uno))));
    }

    @Override
    public int hashCode() {
        return uno.hashCode() + otro.hashCode();
    }
}

