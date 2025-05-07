package com.app;

public class User {
    private String name;
    private String email;
    private String contact;
    private String role;
    private String password;

    // Constructor
    public User(String name, String email, String contact, String role, String password) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.role = role;
        this.password = password;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    // Optional: toString() method for easier debugging
    @Override
    public String toString() {
        return name + "," + email + "," + contact + "," + role + "," + password;
    }
}
