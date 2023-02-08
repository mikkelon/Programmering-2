package opgave_2;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Integer> tal = new ArrayList<>();
        tal.add(1);
        tal.add(1);
        tal.add(0);
        tal.add(0);
        tal.add(0);
        tal.add(1);
        tal.add(1);
        tal.add(0);
        System.out.println("Array      : " + tal.toString());
        System.out.println("Antal 0'er : " + zeroSum(tal));
    }

    public static int zeroSum(ArrayList<Integer> list) {
        return zeroSum(list, 0, list.size() - 1);
    }

    private static int zeroSum(ArrayList<Integer> list, int left, int right) {
        if (left == right) {
            if (list.get(left) == 0) return 1;
            return 0;
        };

        int middle = (left + right) / 2;
        int zeroSum1 = zeroSum(list, left, middle);
        int zeroSum2 = zeroSum(list, middle + 1, right);
        return zeroSum1 + zeroSum2;
    }
}
