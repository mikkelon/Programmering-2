package opgave_5;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        char[] characters = {'G', 'R', 'S', 'G', 'G', 'R', 'S', 'R', 'G', 'G', 'R', 'S', 'G'};
        ArrayList<Character> list = new ArrayList<>();
        for (char c : characters) list.add(c);

        System.out.println("Array inden sortering : " + list);
        quickSortFlag(list);
        System.out.println("Array efter sortering : " + list);
    }

    // S G R - Flaget
    // G R S - Alfabetisk
    public static void quickSortFlag(ArrayList<Character> list) {
        quickSortFlag(list, 0, list.size() - 1);
    }

    private static void quickSortFlag(ArrayList<Character> list, int low, int high) {
        if (low < high) {
            int p = partition(list, low, high);
            quickSortFlag(list, low, p - 1);
            quickSortFlag(list, p + 1, high);

        }
    }

    private static int partition(ArrayList<Character> list, int low, int high) {
        int i = low + 1;
        int j = high;
        while (i <= j) {
            char lowChar = list.get(i);
            char highChar = list.get(j);

            if (lowChar == 'S'  || (lowChar == 'G' && highChar == 'G')) {
                i++;
            }
            else if (highChar == 'R') {
                j--;
            } else {
                swap(list, i, j);
                i++;
                j--;
            }
        }
        swap(list, low, j);
        return j;

    }

    private static void swap(ArrayList<Character> list, int i, int j) {
        char temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
