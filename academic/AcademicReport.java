package academic;

import interfaces.Printable;
import users.Student;
import java.util.List;

public class AcademicReport implements Printable {
    private List<Student> students;

    public AcademicReport(List<Student> students) {
        this.students = students;
    }

    public void generateReport() {
        System.out.println(print());
    }

    public List<Student> getStudents() { return students; }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Academic Report ===\n");
        sb.append("Total students: " + students.size() + "\n");
        for (Student s : students) {
            sb.append("  " + s.getFirstName() + " " + s.getLastName()
                    + " | GPA: " + s.getGpa() + "\n");
        }
        return sb.toString();
    }
}
