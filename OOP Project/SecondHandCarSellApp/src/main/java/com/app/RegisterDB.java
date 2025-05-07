package com.app;

import java.io.*;
import java.util.*;

public class RegisterDB {
    private static final String FILE_PATH = "D:\\OOP Project\\RegisterDatabase.txt"; // Double backslashes for Windows

    // Validate user login
    public static List<User> validate(String regName, String regEmail, String regContact, String regRole, String password) {
        List<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String storedName = parts[0];
                    String storedEmail = parts[1];
                    String storedContact = parts[2];
                    String storedRole = parts[3];
                    String storedPassword = parts[4];

                    if (storedName.equals(regName) && storedPassword.equals(password)) {
                        users.add(new User(storedName, storedEmail, storedContact, storedRole, storedPassword));
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Database file not found at " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    // Method to register a new user
    public static boolean saveUser(String regName, String regEmail, String regContact, String regRole, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(regName + "," + regEmail + "," + regContact + "," + regRole + "," + password);
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            return false;
        }
    }
    
    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    users.add(new User(parts[0], parts[1], parts[2], parts[3], parts[4]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }
    
    public static boolean deleteUserByEmail(String email) {
        List<User> users = getAllUsers();
        boolean found = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : users) {
                if (!user.getEmail().equalsIgnoreCase(email)) {
                    writer.write(user.toString());
                    writer.newLine();
                } else {
                    found = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return found;
    }
    
    public static boolean updateUser(User updatedUser) {
        List<User> users = getAllUsers();
        boolean found = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : users) {
                if (user.getEmail().equalsIgnoreCase(updatedUser.getEmail())) {
                    writer.write(updatedUser.toString());
                    found = true;
                } else {
                    writer.write(user.toString());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return found;
    }





 
}
