package opgave_7;

public class App {
    public static void main(String[] args) {
        System.out.println(talN(3));
        System.out.println(talN(4));
        System.out.println(talN(5));
        System.out.println(talN(6));
        System.out.println();
        System.out.println(talNiterativ(3));
        System.out.println(talNiterativ(4));
        System.out.println(talNiterativ(5));
        System.out.println(talNiterativ(6));
    }

    public static int talN(int n) {
        int result = -1;

        if (n <= 2) {
            if (n == 0) result = 2;
            else if (n == 1) result = 1;
            else if (n == 2) result = 5;
        } else { // hvis n > 2
            if (n % 2 == 0) { // hvis n er lige
                result = (2 * talN(n - 3) - (talN(n - 1)));
            } else { // hvis n er ulige
                result = talN(n - 1) + talN(n - 2) + (3 * talN(n - 3));
            }
        }
        return result;
    }

    public static int talNiterativ(int n) {
        int result = 0;
        int[] temp = {2,1,5};
        if (n <= 2) {
            if (n == 0) result = 2;
            else if (n == 1) result = 1;
            else if (n == 2) result = 5;
        } else { // hvis n > 2
            for (int i = 3; i <= n; i++) {
                int talN = 0;
                if (i % 2 == 0) {
                    talN = 2 * temp[0] - temp[2];
                } else {
                    talN = temp[2] + temp[1] + 3 * temp[0];
                }
                temp[0] = temp[1];
                temp[1] = temp[2];
                temp[2] = talN;
            }
            result = temp[2];
        }
        return result;
    }
}
