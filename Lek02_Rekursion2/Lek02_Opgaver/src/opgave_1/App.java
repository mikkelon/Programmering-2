package opgave_1;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(3);
        ints.add(2);
        ints.add(2);
        ints.add(6);
        ints.add(9);
        ints.add(9);
        ints.add(8);
        System.out.println(ligeTal(ints));
        System.out.println(ligeTal2(ints));
    }

    // #-- MED HJÆLPEMETODE --#
    public static int ligeTal(ArrayList<Integer> list) {
        return ligeTal(list, 0);
    }

    private static int ligeTal(ArrayList<Integer> list, int index) {
        if (index == list.size()) {
            return 0;
        } else if (list.get(index) % 2 == 0){
            return ligeTal(list, index + 1) + 1;
        } else {
            return ligeTal(list, index + 1);
        }
    }

    // #-- UDEN HJÆLPEMETODE --#

    public static int ligeTal2(ArrayList<Integer> list) {
        ArrayList<Integer> listCopy = new ArrayList<>(list);

        if (listCopy.size() > 0) {
            int currInt = listCopy.get(0);
            listCopy.remove(0);
            if (currInt % 2 == 0) {
                return ligeTal2(listCopy) + 1;
            } else {
                return ligeTal2(listCopy);
            }
        }
        return 0;
    }
}
