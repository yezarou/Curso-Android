package buses;

public class EnMatricula implements Criterio {
    String matricula;

    public EnMatricula(String matricula){
        this.matricula = matricula;
    }

    @Override
    public boolean esSeleccionable(Bus bus) {
        return bus.matricula.toUpperCase().contains(bus.matricula.toUpperCase());
    }

    @Override
    public String toString() {
        return "Autobuses cuya matricula contiene " + matricula;
    }
}
