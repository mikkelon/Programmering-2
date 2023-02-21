package opgave_3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student student;

    @Test
    void getId() {
        Student student = new Student(1, "Jane Jensen");
        assertEquals(1, student.getId());
    }

    @Test
    void getName() {
        Student student = new Student(1, "Jane Jensen");
        assertEquals("Jane Jensen", student.getName());
    }

    @Test
    void addGrade() {
        Student student = new Student(1, "Jane Jensen");
        student.addGrade(12);
        student.addGrade(10);
        student.addGrade(7);
        assertEquals(3, student.getGrades().size());
        assertArrayEquals(new Double[]{12.0, 10.0, 7.0}, student.getGrades().toArray());
    }

    @Test
    void getGrades() {
        Student student = new Student(1, "Jane Jensen");
        student.addGrade(12);
        student.addGrade(10);
        student.addGrade(7);
        assertEquals(3, student.getGrades().size());
        assertArrayEquals(new Double[]{12.0, 10.0, 7.0}, student.getGrades().toArray());
    }
}