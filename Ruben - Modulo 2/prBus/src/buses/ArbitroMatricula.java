package buses;

import java.util.Comparator;

public class ArbitroMatricula implements Comparator<Bus> {
    @Override
    public int compare(Bus o1, Bus o2) {
        return o1.getMatricula().toUpperCase().compareTo(o2.getMatricula().toUpperCase());
    }
}
