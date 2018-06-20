package Jarras;

public class Jarra {
    int contenido;
    final int capacidad;

    public Jarra(int capacidad){
        this.capacidad = capacidad;
        contenido = 0;
    }

    public int capacidad() { return capacidad; }
    public int contenido() { return contenido; }
    public void llena() { contenido = capacidad; }
    public void vacia() { contenido = 0; }
    public void llenaDesde (Jarra j){
        while (this.contenido < this.capacidad && j.contenido > 0){
            j.contenido--;
            this.contenido++;
        }
    }
    @Override
    public String toString() {
        return "(" + contenido + " / " + capacidad + ")";
    }
}
