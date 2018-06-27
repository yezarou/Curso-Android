package buses;

import java.util.Comparator;

public class ArbitroBuses implements Comparator<Bus> {
    @Override
    public int compare(Bus o1, Bus o2) {
        int res = Integer.compare(o1.getCodLinea(), o2.getCodLinea());
        if (res == 0)
            res = Integer.compare(o1.getCodBus(), o2.getCodBus());

        return res;
    }
}
