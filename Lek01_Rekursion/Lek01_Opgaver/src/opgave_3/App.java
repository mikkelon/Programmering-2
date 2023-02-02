package opgave_3;

public class App {
    public static void main(String[] args) {
        System.out.println(product(6, 5));
        System.out.println(productRus(6, 5));
    }

    public static int product(int a, int b) {
        int result = 0;

        if (a > 0) {
            result = product(a - 1, b) + b;
        }

        return result;
    }

    public static int productRus(int a, int b) {
        int result = 0;

        if (a > 0) {
            if (a % 2 != 0) { // hvis a er ulige
                result = productRus(a - 1, b) + b;
            } else { // hvis a er lige og over 1, hvilket den altid vil være, da a > 0 og a ikke kan være 1, da det er et ulige tal.
                result = productRus(a / 2, 2 * b);
            }
        }

        return result;
    }
}