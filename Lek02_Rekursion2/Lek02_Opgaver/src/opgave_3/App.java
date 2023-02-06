package opgave_3;

public class App {
    public static void main(String[] args) {
        int[] arr = {0, 3, 6, 8, 19, 20, 22, 25, 29, 32, 45, 47, 50};
        System.out.println(hasTarget(arr, 26));
    }

    public static boolean hasTarget(int[] arr, int target) {
        return hasTarget(arr, target, 0, arr.length - 1);
    }

    private static boolean hasTarget(int[] arr, int target, int left, int right) {
        if (left > right) {
            return false;
        } else {
            int middle = (left + right) / 2;
            int k = arr[middle];
            if (k == target)
                return true;
            else if (k > target) {
                right = middle - 1;
                return hasTarget(arr, target, left, right);
            } else {
                left = middle + 1;
                return hasTarget(arr, target, left, right);
            }
        }
    }

    public static int binSearchArray(int[] arr, int target) {
        int indeks = -1;
        int left = 0;
        int right = arr.length - 1;
        int middle = -1;
        while (indeks == -1 && left <= right) {
            middle = (left + right) / 2;
            int k = arr[middle];
            if (k == target)
                indeks = middle;
            else if (k > target)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return indeks;
    }
}
