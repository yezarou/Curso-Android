package alturas;

public class EnContinente implements Seleccion {
    String continente;

    public EnContinente(String continente){
        this.continente = continente;
    }

    @Override
    public boolean test(Pais pais) {
        return pais.getContinente().contains(continente);
    }
}
