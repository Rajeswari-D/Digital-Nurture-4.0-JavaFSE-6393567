public class TestMVC {
    public static void main(String[] args) {
        // Model
        Student student = new Student("S101", "Ananya", "A");

        // View
        StudentView view = new StudentView();

        // Controller
        StudentController controller = new StudentController(student, view);

        // Initial display
        controller.updateView();

        // Update student details
        controller.setStudentName("Keerthana");
        controller.setStudentGrade("A+");

        // Updated display
        controller.updateView();
    }
}