package opgave_1;

import java.util.HashSet;
import java.util.Set;

public class AnvendMetoderPaaHashSet {
    public static void main(String[] args) {
        // 1)
        Set<Integer> s = new HashSet<>();

        // 2)
        int[] nums = {34, 12, 23, 45, 67, 34, 98};
        for (int n : nums) s.add(n);

        // 3)
        System.out.println("3) " + s.toString());

        // 4)
        s.add(23);

        // 5)
        System.out.println("5) " + s.toString());

        // 6)
        s.remove(67);

        // 7)
        System.out.println("7) " + s.toString());

        // 8)
        System.out.println("8) " + s.contains(23));

        // 9)
        System.out.println("9) " + s.size());
    }
}
