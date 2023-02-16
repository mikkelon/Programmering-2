package opgave_4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(
                List.of(
                "Jan Jensen",
                "Jens Hansen",
                "Leo Hansen",
                "Jens Jensen",
                "Jensine Larsen")
        );

        System.out.println(countDelStrengA(list, "sen"));
        System.out.println(countDelStrengA(list, "ens"));
        System.out.println();

        System.out.println(countDelStrengB(list, "sen"));
        System.out.println(countDelStrengB(list, "ens"));
    }

    // iterativ metode
    public static int countDelStrengA(List<String> list, String sub) {
        int count = 0;

        for (String s : list) {
            for (int i = 0; i < s.length() - (sub.length() - 1); i++) {
                if (s.substring(i, i + sub.length()).equalsIgnoreCase(sub))
                    count++;
            }
        }

        return count;
    }

    // rekursiv metode
    public static int countDelStrengB(List<String> list, String sub) {
        for (String s : list) {

        }
    }

    public static int countDelStrengB(String s, String sub, int index) {
        if (index == s.length() - sub.length()) {
            if (s.equalsIgnoreCase(sub)) return 1;
        } else if (index <= s.length() - sub.length()) {
            return 0;
        } else {
            return countDelStrengB(s.substring(index, index + sub.length()), sub, index + 1);
        }
    }
}
