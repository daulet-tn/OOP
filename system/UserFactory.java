package system;

import enums.ManagerType;
import enums.StudentDegree;
import enums.TeacherTitle;
import users.Admin;
import users.Manager;
import users.ResearchEmployee;
import users.Student;
import users.Teacher;
import users.User;

// Factory pattern — centralized creation of User objects
public class UserFactory {
    private static UserFactory instance;

    private UserFactory() {
        // private constructor — singleton factory
    }

    public static UserFactory getInstance() {
        if (instance == null) {
            instance = new UserFactory();
        }
        return instance;
    }

    public Student createStudent(String userId, String firstName, String lastName,
                                 String email, String password,
                                 String studentId, int year,
                                 StudentDegree degree, String major) {
        return new Student(userId, firstName, lastName, email, password,
                           studentId, year, degree, major);
    }

    public Teacher createTeacher(String userId, String firstName, String lastName,
                                 String email, String password,
                                 String employeeId, String department, double salary,
                                 TeacherTitle title) {
        return new Teacher(userId, firstName, lastName, email, password,
                           employeeId, department, salary, title);
    }

    public Manager createManager(String userId, String firstName, String lastName,
                                 String email, String password,
                                 String employeeId, String department, double salary,
                                 ManagerType type) {
        return new Manager(userId, firstName, lastName, email, password,
                           employeeId, department, salary, type);
    }

    public Admin createAdmin(String userId, String firstName, String lastName,
                             String email, String password) {
        return new Admin(userId, firstName, lastName, email, password);
    }

    public ResearchEmployee createResearchEmployee(String userId, String firstName, String lastName,
                                                   String email, String password,
                                                   String employeeId, String department, double salary) {
        return new ResearchEmployee(userId, firstName, lastName, email, password,
                                    employeeId, department, salary);
    }

    // Generic create-from-role (optional helper)
    public User createByRole(enums.UserRole role,
                             String userId, String firstName, String lastName,
                             String email, String password) {
        switch (role) {
            case ADMIN:
                return createAdmin(userId, firstName, lastName, email, password);
            default:
                throw new IllegalArgumentException(
                    "Role " + role + " requires additional fields; use a typed factory method.");
        }
    }
}
