package fletning;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        FletteSorteringHul metoder = new FletteSorteringHul();
        int[] temparr = {8, 56, 45, 34, 15, 12, 34,
                44};
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : temparr) {
            list.add(n);
        }

        System.out.println("Array inden sortering : " + list.toString());
        metoder.fletteSort(list);
        System.out.println("Array efter sortering : " + list.toString());
    }
}
