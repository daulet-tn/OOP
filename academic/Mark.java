package academic;

import users.Student;

public class Mark implements Comparable<Mark> {
    private Student student;
    private Course course;
    private double att1;
    private double att2;
    private double finalExam;

    public Mark(Student student, Course course, double att1, double att2, double finalExam) {
        this.student = student;
        this.course = course;
        this.att1 = att1;
        this.att2 = att2;
        this.finalExam = finalExam;
    }

    public double getTotal() {
        return att1 + att2 + finalExam;
    }

    public String getLetterGrade() {
        double total = getTotal();
        if (total >= 90) return "A";
        if (total >= 80) return "B";
        if (total >= 70) return "C";
        if (total >= 60) return "D";
        return "F";
    }

    public double getGpaPoint() {
        String grade = getLetterGrade();
        switch (grade) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            default: return 0.0;
        }
    }

    public boolean isPassed() {
        return getTotal() >= 60;
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public double getAtt1() { return att1; }
    public double getAtt2() { return att2; }
    public double getFinalExam() { return finalExam; }

    @Override
    public int compareTo(Mark other) {
        return Double.compare(this.getTotal(), other.getTotal());
    }

    @Override
    public String toString() {
        return course.getName() + ": " + getTotal() + " (" + getLetterGrade() + ")";
    }
}
