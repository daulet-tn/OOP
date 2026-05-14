package academic;

import exceptions.CourseNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseDatabase {
    private List<Course> courses;

    public CourseDatabase() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(String courseId) throws CourseNotFoundException {
        Course found = findCourse(courseId);
        courses.remove(found);
    }

    public Course findCourse(String courseId) throws CourseNotFoundException {
        for (Course c : courses) {
            if (c.getCourseId().equals(courseId)) {
                return c;
            }
        }
        throw new CourseNotFoundException("Course not found: " + courseId);
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }

    public List<Course> getAllCoursesSorted() {
        List<Course> sorted = new ArrayList<>(courses);
        Collections.sort(sorted);
        return sorted;
    }

    public int getTotalCourses() {
        return courses.size();
    }
}
