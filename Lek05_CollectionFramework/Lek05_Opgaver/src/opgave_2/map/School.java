package opgave_2.map;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class School {
    private String name;
    private Map<Integer, Student> students;

    public School(String name) {
        this.name = name;
        students = new HashMap<>();
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
        if (!students.containsKey(student.getId())) {
            students.put(student.getId(), student);
        }
    }

    public void removeStudent(Student student) {
        students.remove(student.getId());
    }

    public LinkedList<Student> getStudents() {
        return new LinkedList<>(students.values());
    }

    // #----------#
    /**
     * Returns the average grade of all grades for all students.
     * @return
     */
    public double averageGrade() {
        double sum = 0.0;
        int count = 0;
        for (Student student : students.values()) {
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
        if (students.containsKey(id)) {
            return students.get(id);
        }
        return null;
    }

    public String toString() {
        return name;
    }
}
