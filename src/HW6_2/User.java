package HW6_2;

public class User extends Person {
    public String login;
    private String password;
    private String email;

    public User(String firstName, String lastName, int age, String dateOfBirth,String login, String password, String email){
        super(firstName, lastName, age, dateOfBirth);
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void printUserInfo(){
        System.out.println("User: " + firstName + " " + getLastName() + ", age " + getAge()
                + "\n date of birth " + getDateOfBirth() + "\n, email: " + email + ", login <" + login
                + ">, password <" + password + ">.");
    }
}