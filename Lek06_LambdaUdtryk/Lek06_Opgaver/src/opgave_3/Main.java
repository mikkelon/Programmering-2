package opgave_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // a) Lav en liste med 8 tal. Udskriv listen vha. en iterartor, uden brug af forEach. (Se i bogen
        // afsnit 15.2.3)
        ArrayList<Integer> numbers = new ArrayList<>(List.of(
                1, 2, 3, 4, 5, 6, 7, 8
        ));

        Iterator<Integer> listIterator = numbers.iterator();
        while (listIterator.hasNext()) System.out.println(listIterator.next());
        System.out.println();

        // b) Lav en map med parrene (2,4), (3,9), (4, 16), (5, 25) og (6,36). Udskriv parrene vha. en
        // iterator på keys.
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 4);
        map.put(3, 9);
        map.put(4, 16);
        map.put(5, 25);
        map.put(6, 36);

        Iterator<Integer> keyIterator = map.keySet().iterator();
        while (keyIterator.hasNext()) {
            int key = keyIterator.next();
            int value = map.get(key);
            System.out.println("key: " + key + ", value: " + value);
        }

//        Iterator<Map.Entry<Integer, Integer>> entryIterator = map.entrySet().iterator();
//        while (entryIterator.hasNext()) {
//            Map.Entry<Integer, Integer> entry = entryIterator.next();
//            int key = entry.getKey();
//            int value = entry.getValue();
//            System.out.println("key: " + key + ", value: " + value);
//        }

    }
}
