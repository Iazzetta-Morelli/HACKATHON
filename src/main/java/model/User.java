package model;

public class User {
    private String username;
    private String email;
    private String password;
    private boolean isLoggedIn;
    
    public User(String username,String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void setLoginStatus (boolean status) {
        isLoggedIn = status;
    }
    
    public boolean getLoginStatus () {
        return isLoggedIn;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getEmail() {
        return this.email;
    }

    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }
    
    
}
