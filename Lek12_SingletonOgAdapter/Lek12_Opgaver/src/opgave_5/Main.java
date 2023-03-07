package opgave_5;

public class Main {
    public static void main(String[] args) {
        Bag<String> bag = new ObservableBag<>();
        bag.registerObserver((t, n) -> {
            String s = "";
            if (t instanceof String)
                s = (String) t; // Typecast bruges kun, hvis der skal anvendes specifikke metoder på objektet,
                                // som kun tilhører objektets klasse
            System.out.println("Observer notified: " + s + ", x" + n);
        });

        bag.add("Test1");
        bag.add("Test2");
        bag.add("Test2");
    }
}
