package opgave_2;

public class App {
    public static void main(String[] args) {
        System.out.println(power(5, 10));
        System.out.println(power2(5, 10));
    }

    public static int power(int n, int p) {
        int result = 0;

        if (p == 1) result = n;
        else if (p == 0) result = 1;
        else result = power(n, p - 1) * n;

        return result;
    }

    public static int power2(int n, int p) {
        int result = 0;

        if (p == 1) result = n;
        else if (p == 0) result = 1;
        else if (p % 2 != 0 && p > 0) result = power2(n, p - 1) * n;
        else if (p % 2 == 0 && p > 0) result = power2(n * n,p / 2);

        return result;
    }
}
