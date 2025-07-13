package Polymorphism;

public class User {

    // TODO: Implement a User class with the following properties:
    //username: representing the username of the user.
    //email: representing the email address of the user.
    private String username;
    private String email;

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // A sample display method looks like the one given in User Class. Make sure you print all the properties in the given order for all the classes
    public void displayInfo() {
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
    }

    public static void main(String[] args) {
        User user = new User("john_doe", "john.doe@example.com");
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());
        user.displayInfo();
    }
}

