package opgave_5;

public class App {
    public static void main(String[] args) {
        System.out.println(binomial(6, 2));
        System.out.println(binomial(7, 3));
    }

    public static int binomial(int n, int m) {
        if (m == 0 || m == n) {
            return 1;
        } else if (0 < m && m < n){
            return binomial(n - 1, m) + binomial(n - 1, m - 1);
        }
        return -1;
    }
}
