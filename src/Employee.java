
import java.util.ArrayList;
import java.util.Scanner;

public class Employee {

    private String id;
    private String name;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void submitFeedback(ArrayList<FeedBack> feedbackList, Scanner scanner, FileHandler fileHandler) {
        String type = "";
        String description;
        boolean valid = false;

        System.out.println("=================================");
        System.out.println("Submit a New Feedback");
        System.out.println("=================================");
        while (!valid) {
            System.out.println("Select the type of issue you are facing:");
            System.out.println("1. Printer issue");
            System.out.println("2. Internet issue");
            System.out.println("3. Computer issue");
            System.out.println("4. \"Sahl\" system Issue");
            System.out.println("5. Other");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                type = "Printer issue";
                valid = true;
            } else if (choice.equals("2")) {
                type = "Internet issue";
                valid = true;
            } else if (choice.equals("3")) {
                type = "Computer issue";
                valid = true;
            } else if (choice.equals("4")) {
                type = "\"Sahl\" system Issue";
                valid = true;
            } else if (choice.equals("5")) {
                type = "Other";
                valid = true;
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        System.out.print("Enter a brief description of the issue: ");
        description = scanner.nextLine();

        String feedbackId = fileHandler.generateFeedbackId(feedbackList);
        FeedBack feedback = new FeedBack(feedbackId, type, description, id, name);
        feedbackList.add(feedback);

        System.out.println("=================================");
        System.out.println("Feedback submitted successfully!");
        System.out.println("Feedback ID: " + feedbackId);
        System.out.println("=================================");
    }
}
