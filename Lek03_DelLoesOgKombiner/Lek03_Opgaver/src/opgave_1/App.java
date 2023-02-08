package opgave_1;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ArrayList<Integer> tal = new ArrayList<>();
        tal.add(2);
        tal.add(4);
        tal.add(6);
        tal.add(8);
        tal.add(10);
        System.out.println("Array : " + tal.toString());
        System.out.println("Sum   : " + sum(tal));
    }

    public static int sum(ArrayList<Integer> list) {
        return sum(list, 0, list.size() - 1);
    }

    private static int sum(ArrayList<Integer> list, int left, int right) {
        if (left == right) return list.get(left);

        int middle = (left + right) / 2;
        int sum1 = sum(list, left, middle);
        int sum2 = sum(list, middle + 1, right);
        return sum1 + sum2;
    }
}
