public class StudentController {
    private final Student student;
    private final StudentView view;

    public StudentController(Student student, StudentView view) {
        this.student = student;
        this.view = view;
    }

    // Model Getters
    public String getStudentName()   { return student.getName(); }
    public String getStudentId()     { return student.getId(); }
    public String getStudentGrade()  { return student.getGrade(); }

    // Model Setters
    public void setStudentName(String name)     { student.setName(name); }
    public void setStudentId(String id)         { student.setId(id); }
    public void setStudentGrade(String grade)   { student.setGrade(grade); }

    // View Update
    public void updateView() {
        view.displayStudentDetails(student.getId(), student.getName(), student.getGrade());
    }
}