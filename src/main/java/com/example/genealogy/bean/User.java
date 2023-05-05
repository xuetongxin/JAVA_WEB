package com.example.genealogy.bean;

public class User {


    private int id;
    private String username;
    private String password;
    private String email;
    private String status;
    public User() {
    }
    public User(String username){
        this.username=username;
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String email,String username, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatue() {
        return status;
    }

    public void setStatue(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id +" "+ username+" "+email+ " "+ status;
    }
}
