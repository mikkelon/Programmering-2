package opgave_3;

public class Main {
    public static void main(String[] args) {
        // Create a School object and fill it with students
        School school = new School("Erhvervsakademi Aarhus");
        school.addStudent(new Student(1, "Hans"));
        school.addStudent(new Student(2, "Peter"));
        school.addStudent(new Student(3, "Jens"));
        school.addStudent(new Student(4, "Mads"));

        // Add grades to Hans
        school.findStudent(1).addGrade(12);
        school.findStudent(1).addGrade(10);
        school.findStudent(1).addGrade(7);

        // Add grades to Peter
        school.findStudent(2).addGrade(7);
        school.findStudent(2).addGrade(12);
        school.findStudent(2).addGrade(12);

        // Add grades to Jens
        school.findStudent(3).addGrade(4);
        school.findStudent(3).addGrade(7);
        school.findStudent(3).addGrade(2);

        // Add grades to Mads
        school.findStudent(4).addGrade(-3);
        school.findStudent(4).addGrade(2);
        school.findStudent(4).addGrade(2);

        // Print information
        System.out.println("School: " + school.getName());
        System.out.println("Students: ");
        for (Student student : school.getStudents()) {
            System.out.println(student);
        }
        System.out.printf("Average grade: %.2f\n", school.averageGrade());
    }
}
