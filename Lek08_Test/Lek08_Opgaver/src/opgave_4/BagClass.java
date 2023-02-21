package opgave_4;

import java.util.HashMap;
import java.util.Iterator;

public class BagClass implements Bag {
    private final HashMap<String, Integer> map;
    // Implementer metoderne fra interfacet Bag

    public BagClass() {
        map = new HashMap<>();
    }

    @Override
    public void add(String s) {
        int count = map.getOrDefault(s, 0);
        map.put(s, count + 1);
    }

    @Override
    public void remove(String s) {
        int count = map.getOrDefault(s, 0);
        if (count > 0) {
            map.put(s, count - 1);
        }
    }

    @Override
    public int getCount(String s) {
        return map.getOrDefault(s, 0);
    }

    // Implementer metoden iterator fra interfacet Iterable
    @Override
    public Iterator<String> iterator() {
        return map.keySet().iterator();
    }
}
