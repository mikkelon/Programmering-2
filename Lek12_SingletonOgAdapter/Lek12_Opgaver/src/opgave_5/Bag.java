package opgave_5;

public interface Bag<T> extends Subject {
    void add(T object);

    void remove(T object);

    int getCount(T object);
}
