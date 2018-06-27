package buses;

import java.util.Comparator;

public class ArbitroCodBus implements Comparator<Bus> {
    @Override
    public int compare(Bus o1, Bus o2) {
        return Integer.compare(o1.getCodBus(), o2.getCodBus());
    }
}
