import enums.UserRole;
public class Student extends User{
    private String studentId;
    private int year;
    private String major;
    private double gpa;
    private int totalCredits;

    private static final int MAX_CREDITS = 21;

    public Student(String userId, String firstName, String lastName, String email, 
    String studentId, int year, String major){
        super(userId, firstName, lastName, email, UserRole.STUDENT);
        this.studentId = studentId;
        this.year = year;
        this.major = major;
        this.gpa = 0.0;
        this.totalCredits = 0;
    }

    //Getters
    public String getStudentId(){return studentId;}
    public int getYear(){return year;}
    public String getMajor(){return major;}
    public String getGpa(){return gpa;}
    
    //Setter
    public void setGpa(double gpa){this.gpa = gpa;}

    
}
