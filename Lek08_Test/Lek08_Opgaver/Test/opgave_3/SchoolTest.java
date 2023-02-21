package opgave_3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {
    private School school;
    private Student s1, s2, s3;

    @BeforeEach
    void setUp() {
        school = new School("TestSchool");
        s1 = new Student(1, "TestStudent");
        s2 = new Student(2, "TestStudent2");
        s3 = new Student(3, "TestStudent3");
    }

    @Test
    void getName() {
        assertEquals("TestSchool", school.getName());
    }

    @Test
    void addStudent() {
        school.addStudent(s1);
        assertTrue(school.getStudents().contains(s1));
        assertFalse(school.getStudents().contains(s2));
    }

    @Test
    void removeStudent() {
        school.addStudent(s1);
        school.addStudent(s2);
        school.removeStudent(s1);
        assertFalse(school.getStudents().contains(s1));
        assertTrue(school.getStudents().contains(s2));
    }

    @Test
    void getStudents() {
        school.addStudent(s1);
        school.addStudent(s2);
        assertTrue(school.getStudents().contains(s1));
        assertTrue(school.getStudents().contains(s2));
        assertFalse(school.getStudents().contains(s3));
    }

    @Test
    void averageGrade() {
        school.addStudent(s1);
        s1.addGrade(12.0);
        s1.addGrade(10.0);
        s1.addGrade(7.0);
        school.addStudent(s2);
        s2.addGrade(4.0);
        s2.addGrade(7.0);
        s2.addGrade(10.0);
        school.addStudent(s3);
        s3.addGrade(12.0);
        s3.addGrade(12.0);
        s3.addGrade(12.0);
        assertEquals(9.5, school.averageGrade(), 0.1);
        assertNotEquals(10.0, school.averageGrade());
    }

    @Test
    void findStudent() {
        school.addStudent(s1);
        assertEquals(s1, school.findStudent(1));
    }
}