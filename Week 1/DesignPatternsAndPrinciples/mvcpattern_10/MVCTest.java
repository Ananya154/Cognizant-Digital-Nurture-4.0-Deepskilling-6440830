package mvcpattern_10;

public class MVCTest {
    public static void main(String[] args) {

        Student student = new Student("Ananya", "S101", "A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);

        controller.updateView();

        System.out.println("\n-Updating student details...\n");

        controller.setStudentName("Ravi");
        controller.setStudentId("S102");
        controller.setStudentGrade("B+");

        controller.updateView();
    }
}
