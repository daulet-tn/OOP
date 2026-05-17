package users;
import enums.UserRole;
import common.Massage;
import java.util.ArrayList;
import java.util.List;

public abstract class User implements Printable, Comparable<User>, java.io.Serializable {
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

    public void reciveMassage(Massage msg){
        inbox.add(msg);
    }

    public void inbox(){
        if (inbox.isEmpty()){
            System.out.println("Inbox is empty.");
            return;
        }
        for (Massage m : inbox){
            System.out.println(m);
        }
    }


    // Getters
    public String getUserId(){return userId;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getEmail(){return email;}
    public String getRole(){return role;}
    public boolean isLoggedIn(){return isLoggedIn;}

    //Setters 
    public void setFirstName(String firstName){this.firstName = firstName;}
    public void setLastName(String lastName){this.lastName = lastName;}
    public void setEmail(String email){this.email = email;}

    @Override
    public String toString(){
        return firstName + " " + lastName + " ( " + role + " )";
    }

    @Override
    public String print(){
        return "User( Id = " + userId + ", name = " + firstName + " " + lastName + 
        ", email = " + email + ", role = " + role + ")";
    }

    @Override
    public int compareTo(User other){
        return this.lastName.compareTo(other.lastName);
    }

    @Override
    public boolean equals(Object o){
        if (this == o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId);
    }

    @Override
    public int hashCode(){
        return userId.hashCode();
    }
}
