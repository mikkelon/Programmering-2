package opgave_3;

import java.util.LinkedList;
import java.util.List;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private List<Double> grades;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        grades = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // #----------#
    public void addGrade(double grade) {
        grades.add(grade);
    }

    public LinkedList<Double> getGrades() {
        return new LinkedList<>(grades);
    }

    public String toString() {
        return "(" + id + ") " + name;
    }

    @Override
    public int compareTo(Student o) {
        if (id < o.id) {
            return -1;
        } else if (id > o.id) {
            return 1;
        } else {
            return 0;
        }
    }
}
