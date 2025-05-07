package Login.app;

import java.io.*;
import java.util.*;

public class LoginDB {
    private static final String FILE_PATH = "D:\\OOP Project\\LoginDatabase.txt"; // Use double backslashes if on Windows

    // Validate user login
    public static List<LoginUser> validate(String userName, String password) {
        List<LoginUser> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String storedUsername = parts[0];
                    String storedPassword = parts[1];


                    if (storedUsername.equals(userName) && storedPassword.equals(password)) {
                        users.add(new LoginUser(storedUsername, storedPassword));
                        break; // Stop searching once a match is found
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

    // Method to Register a User
    public static boolean saveUser(String userName, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(userName + "," + password);
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            return false;
        }
    }

}
