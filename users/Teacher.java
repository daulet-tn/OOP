package users;

import enums.UserRole;
import enums.TeacherTitle;

public class Teacher extends User {
    private TeacherTitle title;
    private double rating;
    private int ratingCount;

    public Teacher(String userId, String firstName, String lastName, String email, TeacherTitle title) {
        super(userId, firstName, lastName, email, UserRole.TEACHER);
        this.title = title;
        this.rating = 0.0;
        this.ratingCount = 0;
    }

    public TeacherTitle getTitle() { return title; }
    public double getRating() { return rating; }
    public int getRatingCount() { return ratingCount; }

    public void addRating(double r) {
        rating = (rating * ratingCount + r) / (ratingCount + 1);
        ratingCount++;
    }
}
