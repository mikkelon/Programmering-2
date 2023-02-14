package opgave_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("Lek05_CollectionFramework\\Lek05_Opgaver\\src\\opgave_4\\film.txt");
        Map<String, LinkedList<Integer>> map = new HashMap<>();

        readFile(file, map);
//        System.out.println(map.values());
        printGrades(map);
    }

    private static void readFile(File file, Map<String, LinkedList<Integer>> map) {
        try (Scanner scanner = new Scanner(file)) {
            int grades = 0;
            try {
                grades = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }

            for (int i = 0; i < grades; i++) {
                String movie = scanner.nextLine();
                int grade = Integer.parseInt(scanner.nextLine());

                if (map.containsKey(movie)) {
                    map.get(movie).add(grade);
                } else {
                    LinkedList<Integer> temp = new LinkedList<>();
                    temp.add(grade);
                    map.put(movie, temp);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printGrades(Map<String, LinkedList<Integer>> map) {
        for (Map.Entry<String, LinkedList<Integer>> entry : map.entrySet()) {
            String movieName = entry.getKey();
            LinkedList<Integer> grades = entry.getValue();
            double sum = 0.0;
            int count = 0;
            for (int grade : grades) {
                sum += grade;
                count++;
            }
            double averageGrade = sum / count;
            System.out.printf("%s: %d karakterer, gennemsnit %.1f\n", movieName, count, averageGrade);
        }
    }
}
