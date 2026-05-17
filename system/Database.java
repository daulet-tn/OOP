package system;

import academic.Course;
import exceptions.CourseNotFoundException;
import exceptions.UserNotFoundException;
import exceptions.UserAlreadyExistsException;
import users.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Singleton — system-wide storage of users and courses
public class Database {
    private static Database instance;

    private final Map<String, User>   users   = new HashMap<>();
    private final Map<String, Course> courses = new HashMap<>();

    private Database() {
        // private constructor — singleton
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    // ─────────────── USERS ───────────────
    public void addUser(User user) throws UserAlreadyExistsException {
        if (users.containsKey(user.getUserId())) {
            throw new UserAlreadyExistsException("User already exists: " + user.getUserId());
        }
        users.put(user.getUserId(), user);
        Logger.getInstance().log("DB: added user " + user.getUserId());
    }

    public void removeUser(String id) throws UserNotFoundException {
        if (!users.containsKey(id)) {
            throw new UserNotFoundException("User not found: " + id);
        }
        users.remove(id);
        Logger.getInstance().log("DB: removed user " + id);
    }

    public void updateUser(User user) throws UserNotFoundException {
        if (!users.containsKey(user.getUserId())) {
            throw new UserNotFoundException("User not found: " + user.getUserId());
        }
        users.put(user.getUserId(), user);
        Logger.getInstance().log("DB: updated user " + user.getUserId());
    }

    public User getUser(String id) throws UserNotFoundException {
        User u = users.get(id);
        if (u == null) {
            throw new UserNotFoundException("User not found: " + id);
        }
        return u;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    // ─────────────── COURSES ───────────────
    public void addCourse(Course course) {
        courses.put(course.getCourseId(), course);
        Logger.getInstance().log("DB: added course " + course.getCourseId());
    }

    public Course getCourse(String id) throws CourseNotFoundException {
        Course c = courses.get(id);
        if (c == null) {
            throw new CourseNotFoundException("Course not found: " + id);
        }
        return c;
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses.values());
    }

    public int getTotalUsers()   { return users.size();   }
    public int getTotalCourses() { return courses.size(); }

    public void clear() {
        users.clear();
        courses.clear();
    }
}
