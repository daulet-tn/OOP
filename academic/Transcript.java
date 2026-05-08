package academic;

import interfaces.Printable;
import users.Student;
import java.util.List;

public class Transcript implements Printable {
    private Student student;
    private List<Mark> marks;
    private double gpa;

    public Transcript(Student student, List<Mark> marks) {
        this.student = student;
        this.marks = marks;
        this.gpa = calculateGpa();
    }

    private double calculateGpa() {
        if (marks.isEmpty()) return 0.0;
        double sum = 0;
        for (Mark m : marks) {
            sum += m.getGpaPoint();
        }
        return sum / marks.size();
    }

    public void printTranscript() {
        System.out.println(print());
    }

    public Student getStudent() { return student; }
    public List<Mark> getMarks() { return marks; }
    public double getGpa() { return gpa; }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Transcript for " + student.getFirstName() + " " + student.getLastName() + " ===\n");
        for (Mark m : marks) {
            sb.append("  " + m.toString() + "\n");
        }
        sb.append("GPA: " + String.format("%.2f", gpa));
        return sb.toString();
    }
}
