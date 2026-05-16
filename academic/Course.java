package academic;

import users.Student;
import users.Teacher;
import enums.LessonType;
import java.util.ArrayList;
import java.util.List;

public class Course implements Comparable<Course> {
    private String courseId;
    private String name;
    private int credits;
    private int maxStudents;
    private Teacher teacher;
    private List<Student> students;
    private List<Lesson> lessons;

    public Course(String courseId, String name, int credits, int maxStudents) {
        this.courseId = courseId;
        this.name = name;
        this.credits = credits;
        this.maxStudents = maxStudents;
        this.students = new ArrayList<>();
        this.lessons = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (students.size() < maxStudents) {
            students.add(student);
        }
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void addLesson(LessonType type, String topic) {
        String lessonId = courseId + "_L" + (lessons.size() + 1);
        Lesson lesson = new Lesson(lessonId, type, topic, this.teacher);
        lessons.add(lesson);
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getCourseId() { return courseId; }
    public String getName() { return name; }
    public int getCredits() { return credits; }
    public int getMaxStudents() { return maxStudents; }
    public Teacher getTeacher() { return teacher; }
    public List<Student> getStudents() { return students; }
    public List<Lesson> getLessons() { return lessons; }

    @Override
    public int compareTo(Course other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return courseId + ": " + name + " (" + credits + " credits)";
    }
}
