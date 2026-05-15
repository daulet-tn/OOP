package users;
import enums.UserRole;

public abstract class User{
    protected String userId;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected UserRole role;

    public User(String userId, String firstName, String lastName, String email, UserRole role){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    // Getters
    public String getUserId(){return userId;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getEmail(){return email;}
    public UserRole getRole(){return role;}

    //Setters 
    public void setFirstName(String firstName){this.firstName = firstName;}
    public void setLastName(String lastName){this.lastName = lastName;}
    public void setEmail(String email){this.email = email;}

    @Override
    public String toString(){
        return firstName + " " + lastName + " ( " + role + " )";
    }
}