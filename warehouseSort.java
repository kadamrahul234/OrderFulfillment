package warehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class warehouseSort {

    public List<Warehouse> solve(List<Warehouse> warehouses) {
        Collections.sort(warehouses, Comparator.comparingInt(Warehouse::getLocation));
        return warehouses;
    }

    
}
