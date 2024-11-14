/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmain251;


import java.io.*;
import java.util.Scanner;
/**
 *
 * @author jood
 */


public class ProjectMain251 {

private static final String FILE_NAME = "/Users/jood/Desktop/Feedback.txt";

        
 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Submit Feedback");
            System.out.println("2. Search Feedback by User ID");
            System.out.println("3. Print All Feedback");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter your User ID: ");
                String userId = scanner.nextLine();
                System.out.print("Enter your feedback: ");
                String feedbackDescription = scanner.nextLine();
                submitFeedback(new Feedback(userId, feedbackDescription));
            }  else if (choice == 2) {
                System.out.print("Enter the User ID to search: ");
                String userId = scanner.nextLine();
                searchById(userId);
            } 
               else if (choice == 3) {
                printAllFeedbacks();
            }  else if (choice == 4) {
                System.out.println("Exiting...");
                scanner.close();
                return;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void submitFeedback(Feedback feedback) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(feedback.getEntry());
            writer.newLine();
            System.out.println("Feedback submitted successfully.");
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        
    }

   

    private static void searchById(String userId) {
        boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
       
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\ |");
                if (parts[0].equals(userId)) {
                    System.out.println("User ID: " + parts[0]);
                    System.out.println("Description: " + parts[1]);
                    System.out.println("Timestamp: " + parts[2]);
                    System.out.println("-----");
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No feedback found for User ID: " + userId);
            }
            reader.close(); 
        }
         catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
    
     private static void printAllFeedbacks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("All Feedbacks:");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\ |");
                System.out.println("User ID: " + parts[0]);
                System.out.println("Description: " + parts[1]);
                System.out.println("Timestamp: " + parts[2]);
                System.out.println("-----");
            } reader.close();
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}
