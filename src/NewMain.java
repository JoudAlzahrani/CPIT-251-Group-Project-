
import java.util.ArrayList;
import java.util.Scanner;



public class NewMain {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.loadEmployees("employees.txt");
        ArrayList<FeedBack> feedbackList = fileHandler.loadFeedbacks();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==============================================");
            System.out.println("Welcome to the Feedback Management application!");
            System.out.println("==============================================");
            System.out.println("Please select your Employee Type:");
            System.out.println("1. General Employee");
            System.out.println("2. Technical Support Employee");
            System.out.println("3. Exit");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");
            String roleChoice = scanner.nextLine();

            if (!roleChoice.equals("1") && !roleChoice.equals("2") && !roleChoice.equals("3")) {
                System.out.println("Invalid choice. Please select a valid option.");
                continue;
            }

            if (roleChoice.equals("3")) {
                System.out.println("=================================");
                System.out.println("Thank you for using the system. Goodbye!");
                break;
            }

            System.out.print("Enter your ID: ");
            String id = scanner.nextLine();
            String[] user = fileHandler.findUserById(id);

            if (user == null) {
                System.out.println("Invalid ID. Please try again.");
                continue;
            }

            System.out.println("=================================");
            if (roleChoice.equals("1") && user[1].equalsIgnoreCase("staff")) {
                System.out.println("Welcome, " + user[2] + "!");
                System.out.println("You are now logged in as a General Emloyee.");
                Employee employee = new Employee(user[0], user[2]);
                handleEmployeeActions(employee, scanner, feedbackList, fileHandler);
            } else if (roleChoice.equals("2") && user[1].equalsIgnoreCase("it")) {
                System.out.println("Welcome, " + user[2] + "!");
                System.out.println("You are now logged in as a Technical Support Employee.");
                ITEmployee itEmployee = new ITEmployee(user[0], user[2]);
                handleITActions(itEmployee, scanner, feedbackList, fileHandler);
            } else {
                System.out.println("Invalid role. Please try again.");
            }
            System.out.println("=================================");
        }
    }

    private static void handleEmployeeActions(Employee employee, Scanner scanner, ArrayList<FeedBack> feedbackList, FileHandler fileHandler) {
        while (true) {
            System.out.println("==============================");
            System.out.println("      Employee Dashboard");
            System.out.println("==============================");
            System.out.println("1. Submit a New Feedback");
            System.out.println("2. Check My Submitted Feedback");
            System.out.println("3. Logout");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                employee.submitFeedback(feedbackList, scanner, fileHandler);
                fileHandler.saveFeedBacks(feedbackList);
            } else if (choice.equals("2")) {
                employee.viewFeedback(feedbackList);
            } else if (choice.equals("3")) {
                System.out.println("=================================");
                System.out.println("You have successfully logged out.");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleITActions(ITEmployee itEmployee, Scanner scanner, ArrayList<FeedBack> feedbackList, FileHandler fileHandler) {
        while (true) {
            System.out.println("=====================================");
            System.out.println(" Technical Support Employee Dashboard");
            System.out.println("=====================================");
            System.out.println("1. View Solved and Responded Issues");
            System.out.println("2. View and Respond to Unsolved Issues");
            System.out.println("3. Logout");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                itEmployee.viewSolvedAndRespondedIssues(feedbackList);
            } else if (choice.equals("2")) {
                itEmployee.viewAndRespondToUnsolvedIssues(feedbackList, scanner, fileHandler);
            } else if (choice.equals("3")) {
                System.out.println("=================================");
                System.out.println("You have successfully logged out.");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
   
