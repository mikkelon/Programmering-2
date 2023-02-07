package opgave_7;

public class App {
    public static void main(String[] args) {
        System.out.println("Rekursiv metode:");
        System.out.println("n = 3 : " + talN(3));
        System.out.println("n = 4 : " + talN(4));
        System.out.println("n = 5 : " + talN(5));
        System.out.println("n = 6 : " + talN(6));
        System.out.println("\nIterativ metode:");
        System.out.println("n = 0 : " + talNiterativ(0));
        System.out.println("n = 1 : " + talNiterativ(1));
        System.out.println("n = 2 : " + talNiterativ(2));
        System.out.println("n = 3 : " + talNiterativ(3));
        System.out.println("n = 4 : " + talNiterativ(4));
        System.out.println("n = 5 : " + talNiterativ(5));
        System.out.println("n = 6 : " + talNiterativ(6));
    }

    public static int talN(int n) {
        int result = -1;

        if (n == 0) result = 2;
        else if (n == 1) result = 1;
        else if (n == 2) result = 5;
        else if (n > 2) {
            if (n % 2 == 0) { // hvis n er lige
                result = (2 * talN(n - 3) - (talN(n - 1)));
            } else { // hvis n er ulige
                result = talN(n - 1) + talN(n - 2) + (3 * talN(n - 3));
            }
        }
        return result;
    }

    public static int talNiterativ(int n) {
        int result = -1;
        int[] temp = { // i starten af funktionen, passer indeks-tallene med de tilsvarende n-værdier:
                2,  // n = 0
                1,  // n = 1
                5}; // n = 2

        /* Efter loopet har kørt, svarer arrayet til:
         *  temp[0] = n - 3
         *  temp[1] = n - 2
         *  temp[2] = n - 1 */

        if (0 <= n && n <= 2) result = temp[n];
        else if (n > 2) {
            for (int i = 3; i <= n; i++) { // start på 3, da n = {0..2} er håndteret
                int talN = 0;
                if (i % 2 == 0) { // hvis n
                    talN = 2 * temp[0] - temp[2]; // 2 * n-3 - n-1
                } else {
                    talN = temp[2] + temp[1] + 3 * temp[0]; // n-1 + n-2 + 3 * n-3
                }
                // flyt alle værdier én plads til venstre i arrayet
                // og indsæt den nye værdi på sidste plads.
                temp[0] = temp[1];
                temp[1] = temp[2];
                temp[2] = talN;
            }
            // efter endt loop, sæt result til det sidste tal i arrayet
            result = temp[2];
        }

        return result;
    }
}
