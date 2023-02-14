package opgave_3;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Børge");
        Student student2 = new Student(2, "Anders");

        Set<Student> set = new TreeSet<>();
        set.add(student1);
        set.add(student2);
        System.out.println(set);

        set = new TreeSet<>(new StudentComparator());
        set.add(student1);
        set.add(student2);
        System.out.println(set);
    }
}
