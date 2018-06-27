package buses;

import java.util.Comparator;

public class ArbitroCodLinea implements Comparator<Bus> {
    @Override
    public int compare(Bus o1, Bus o2) {
        return Integer.compare(o1.getCodLinea(), o2.getCodLinea());
    }
}
