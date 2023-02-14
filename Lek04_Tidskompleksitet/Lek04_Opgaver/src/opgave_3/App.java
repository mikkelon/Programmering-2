package opgave_3;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] arr = {5, 10, 5, 6, 4, 9, 8};

        System.out.println(Arrays.toString(prefixAverage(arr)));
    }

    public static double[] prefixAverage(int[] inputArr) {
        double[] temp = new double[inputArr.length];
        temp[0] = inputArr[0];
        int sum = inputArr[0];

        for (int i = 1; i < temp.length; i++) {
            sum += inputArr[i];
            temp[i] = sum / (i + 1.0);
        }

        return temp;
    }


}
