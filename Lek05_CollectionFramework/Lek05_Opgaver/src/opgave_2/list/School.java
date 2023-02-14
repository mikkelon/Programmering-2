package opgave_2.list;

import java.util.LinkedList;
import java.util.List;

public class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        students = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    // #----------#
    /**
     * Adds a student to the school if the student is not already in the school.
     * Pre: Student != null
     * @param student
     */
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public LinkedList<Student> getStudents() {
        return new LinkedList<>(students);
    }

    // #----------#
    /**
     * Returns the average grade of all grades for all students.
     * @return
     */
    public double averageGrade() {
        double sum = 0.0;
        int count = 0;
        for (Student student : students) {
            for (double grade : student.getGrades()) {
                sum += grade;
                count++;
            }
        }
        return sum / count;
    }

    /**
     * Returns a Student object with the given id.
     * If no student with the given id exists, null is returned.
     * @return
     */
    public Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public String toString() {
        return name;
    }
}
