package prUrna;

import java.util.NoSuchElementException;
import java.util.Random;

public class Urna {
    public enum ColorBola { Blanca, Negra };
    private static Random rnd = new Random();

    private int blancas;
    private int negras;

    public Urna (int blancas, int negras) {
        if (blancas < 0 || negras < 0 || blancas + negras == 0)
            throw new IllegalArgumentException();

        this.blancas = blancas;
        this.negras = negras;
    }

    public int totalBolas() {
        return blancas + negras;
    }

    public ColorBola extraerBola() {
        if (totalBolas() == 0)
            throw new NoSuchElementException();

        if(rnd.nextInt(totalBolas()) < blancas) {
            blancas--;
            return ColorBola.Blanca;
        } else {
            negras--;
            return ColorBola.Negra;
        }
    }

    public void ponerBlanca() { blancas++; }
    public void ponerNegras() { negras++; }

    @Override
    public String toString() {
        return "Blancas: " + blancas + ", Negras: " + negras;
    }
}
