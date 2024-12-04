
import java.util.ArrayList;
import java.util.Scanner;

public class ITEmployee {

    private String id;
    private String name;

    public ITEmployee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void viewAndRespondToUnsolvedIssues(ArrayList<FeedBack> feedbackList, Scanner scanner, FileHandler fileHandler) {
        System.out.println("=================================");
        System.out.println("Unsolved Issues");
        System.out.println("=================================");
        System.out.println("FB_ID   | Type               | Description          | Previous Response");
        System.out.println("--------|--------------------|----------------------|------------------------");

        boolean found = false;
        for (int i = 0; i < feedbackList.size(); i++) {
            FeedBack feedback = feedbackList.get(i);
            if ("Unsolved".equalsIgnoreCase(feedback.getStatus())) {
                System.out.printf("%d. %-8s| %-18s| %-22s| %-24s%n",
                        i + 1,
                        feedback.getId(),
                        feedback.getType(),
                        feedback.getDescription(),
                        (feedback.getItResponse() != null ? feedback.getItResponse() : "No response yet"));
                found = true;
            }
        }

        if (!found) {
            System.out.println("No unsolved issues found.");
            System.out.println("=================================");
            return;
        }

        System.out.println("=================================");
        System.out.print("Enter the number of the issue you want to respond to (or 0 to go back): ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Returning to menu.");
            return;
        }

        if (choice == 0) {
            return;
        }

        if (choice > 0 && choice <= feedbackList.size()) {
            FeedBack selectedFeedback = feedbackList.get(choice - 1);
            if (!"Unsolved".equalsIgnoreCase(selectedFeedback.getStatus())) {
                System.out.println("This issue is already resolved or responded to. Returning to menu.");
                return;
            }

            System.out.print("Enter your response: ");
            String response = scanner.nextLine();
            selectedFeedback.setItResponse(response);
            selectedFeedback.setRespondedBy(name);

            System.out.print("Mark this issue as (1: Solved, 2:Unsolved): ");
            int statusChoice;
            try {
                statusChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Returning to menu.");
                return;
            }
            if (statusChoice == 1) {
                selectedFeedback.setStatus("Solved");
            } else if (statusChoice == 2) {
                selectedFeedback.setStatus("Unsolved");
            } else {
                System.out.println("Invalid status choice. Returning t menu.");
                return;
            }
            //responses.txt
            fileHandler.saveResponse(selectedFeedback, id, name);
            // feedbacks.txt
            fileHandler.saveFeedBacks(feedbackList);
            System.out.println("=================================");
            System.out.println("Response has been submitted successfully.");
            System.out.println("=================================");
        }
    }
        public void viewSolvedAndRespondedIssues(ArrayList<FeedBack> feedbackList) {
        System.out.println("=================================");
        System.out.println("Solved and Responded Issues");
        System.out.println("=================================");
        System.out.println("FB_ID   | Type               | Description          | Status    | Responded By");
        System.out.println("--------|--------------------|----------------------|-----------|----------------------");

        boolean found = false;

        for (FeedBack feedback : feedbackList) {
            if ("Solved".equalsIgnoreCase(feedback.getStatus())) {
                System.out.printf("%-8s| %-18s| %-22s| %-10s| %-22s%n",
                        feedback.getId(),
                        feedback.getType(),
                        feedback.getDescription(),
                        feedback.getStatus(),
                        feedback.getRespondedBy());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No solved issues found.");
        }
        System.out.println("=================================");
    }
}

