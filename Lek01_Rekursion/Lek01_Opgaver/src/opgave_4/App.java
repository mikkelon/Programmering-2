package opgave_4;

import java.util.Queue;

public class App {
    public static void main(String[] args) {
        String s = "RANSLIRPA";
        System.out.println(reverse(s));
    }

    // REKURSIV DEFINITION
    // Termineringsregel : s.length() = 0, s.length() = 1
    // Rekurrensregel    :
    public static String reverse(String s) {
        String result = "";

        if (s.length() == 1) {
            result = s;
        } else if (s.length() > 1) {
            result = s.substring(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
            // result = reverse(s.substring(1)) + s.charAt(0);
        }

        return result; // hvis strengen s er 0 lang, vil den springe over if-statement og returnere "".
    }
}
