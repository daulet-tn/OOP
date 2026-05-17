package users;
import enums.UserRole;
import system.Database;
import system.Logger;
import java.util.List;

public class Admin extends User{

    public Admin(String userId, String firstName, String lastName, String email, String passwordHash){
        super(userId, firstName, lastName, email, passwordHash, UserRole.ADMIN);
    }

    public void addUser(User user) {
        try {
            Database.getInstance().addUser(user);
            Logger.getInstance().log("Admin " + firstName + " added user: " + user);
            System.out.println("User added: " + user);
        } 
        catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void removeUser(String userId) {
        try {
            Database.getInstance().removeUser(userId);
            Logger.getInstance().log("Admin " + firstName + " removed user: " + userId);
            System.out.println("User removed: " + userId);
        } 
        catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void updateUser(User user) {
        try {
            Database.getInstance().updateUser(user);
            Logger.getInstance().log("Admin " + firstName + " updated user: " + user.getUserId());
            System.out.println("User updated: " + user);
        } 
        catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void viewLogs(){
        System.out.println("==== System Logs ====");
        List<String> logs = Logger.getInstance().getLogs();
        for (String log : logs){
            System.out.println(log);
        }
    }

    public void viewAllUsers(){
        System.out.println("==== All Users ====");
        for (User u : Database.getInstance().getAllUsers()){
            System.out.println(" " + u.print());
        }
    }

    @Override
    public String print(){
        return "Admin ( name = " + firstName + " " + lastName + ", email = " + email + ")";
    }
}    
