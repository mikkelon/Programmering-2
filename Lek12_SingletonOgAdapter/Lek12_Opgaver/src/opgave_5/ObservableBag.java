package opgave_5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ObservableBag<T> implements Bag<T>, Iterable<T> {
    private final HashMap<T, Integer> map;
    private final Set<Observer> observers;

    public ObservableBag() {
        map = new HashMap<>();
        observers = new HashSet<>();
    }

    // Implementerer metoder fra Bag interfacet
    @Override
    public void add(T t) {
        int count = map.getOrDefault(t, 0);
        map.put(t, count + 1);

        notifyObservers(t, map.get(t));
    }

    @Override
    public void remove(T t) {
        int count = map.getOrDefault(t, 0);
        if (count > 0) {
            map.put(t, count - 1);
        }

        notifyObservers(t, map.get(t));
    }

    @Override
    public int getCount(T t) {
        return map.getOrDefault(t, 0);
    }

    // Implementerer metoden iterator fra interfacet Iterable
    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    private void notifyObservers(T t, int amount) {
        for (Observer o : observers) {
            o.update(t, amount);
        }
    }
}
