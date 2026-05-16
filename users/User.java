package users;
import enums.UserRole;
import common.Massage;
import java.util.ArrayList;
import java.util.List;

public abstract class User{
    protected String userId;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String passwordHash;
    protected UserRole role;
    protected boolean isLoggedIn;
    protected List<Massage> inbox = new ArrayList<>();

    public User(String userId, String firstName, String lastName, String email,
                String passwordHash, UserRole role){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.isLoggedIn = false;
    }

    public boolean login(String password){
        if(this.passwordHash.equals(password)){
            this.isLoggedIn = true;
            System.out.println(firstName + " " + lastName + " logged in.");
            return true;
        }
        System.out.println("Wrong password for " + email);
        return false;
    }

    public void logout(){
        this.isLoggedIn = false;
        System.out.println(firstName + " " + lastName + " logged out.");
    }

    public void sendMassage(User to, String text){
        Massage msg = new Massage(this, to, text);
        to.reciveMassage(msg);
        System.out.println("Massage sent: " + this.firstName + " -> " + to.firstName);
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