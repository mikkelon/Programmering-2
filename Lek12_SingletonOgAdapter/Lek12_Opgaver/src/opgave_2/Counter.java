package opgave_2;

public class Counter {
    private static Counter instance;
    private int value;
    private Counter() {
        value = 0;
    }

    public int getValue() {
        return value;
    }

    public void count() {
        value++;
    }

    public void times2() {
        value += value;
    }

    public void zero() {
        value = 0;
    }

    public static Counter getInstance() {
        if (instance == null) {
            instance = new Counter();
        }
        return instance;
    }
}
