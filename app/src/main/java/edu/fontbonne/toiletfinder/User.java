package edu.fontbonne.toiletfinder;

public class User {
    private String username;
    private String emailAddress;
    private String password;
    private String userID;

    User(){

    }
    public User(String username, String emailAddress, String password,String userID) {
        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
