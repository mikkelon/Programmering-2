package opgave_1;

public class App {
    public static void main(String[] args) {
        System.out.println(factorial(6));
    }

    public static int factorial(int n) {
        int result = 0;
        if (n == 1) {
            result = 1;
        } else {
            result = n * factorial(n - 1);
        }
        return result;
    }
}
