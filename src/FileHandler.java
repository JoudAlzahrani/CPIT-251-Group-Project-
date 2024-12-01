
import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private String[][] employees = new String[20][4];
    private int employeeCount = 0;

    public String generateFeedbackId(ArrayList<FeedBack> feedbackList) {
        int maxId = 0;

        for (FeedBack feedback : feedbackList) {
            String currentId = feedback.getId().replace("FB", "");
            try {
                int idNumber = Integer.parseInt(currentId);
                if (idNumber > maxId) {
                    maxId = idNumber;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error parsing feedback ID: " + currentId);
            }
        }
        return "FB" + (maxId + 1);
    }

    public void loadEmployees(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                employees[employeeCount][0] = parts[0].trim(); // ID 
                employees[employeeCount][1] = parts[1].trim(); // Role
                employees[employeeCount][2] = parts[2].trim(); // Name
                employees[employeeCount][3] = parts[3].trim(); // Email 
                employeeCount++;
            }
        } catch (IOException e) {
            System.out.println("Error reading employees file: "
                    + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error closing the file: " + e.getMessage());
                }
            }
        }
    }

    public String[] findUserById(String id) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i][0].equals(id)) {
                return employees[i];
            }
        }
        return null;
    }

    public ArrayList<FeedBack> loadFeedbacks() {
        ArrayList<FeedBack> feedbackList = new ArrayList<FeedBack>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("feedbacks.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                FeedBack feedback = new FeedBack(parts[0], parts[1],
                        parts[2], parts[3], parts[4]);
                feedback.setStatus(parts[5]);
                feedback.setItResponse(parts.length > 6 ? parts[6] : null);
                feedback.setRespondedBy(parts.length > 7 ? parts[7] : null);
// respondedBy RUBA
                feedbackList.add(feedback);
            }
        } catch (IOException e) {
            System.out.println("No previous feedbacks found.");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error closing the file: "
                            + e.getMessage());
                }
            }
        }
        return feedbackList;
    }

    public void saveFeedbacks(ArrayList<FeedBack> feedbackList) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("feedbacks.txt"));
            for (FeedBack feedback : feedbackList) {
                writer.write(feedback.getId() + "," + feedback.getType()
                        + "," + feedback.getDescription() + ","
                        + feedback.getCreatedBy() + ","
                        + feedback.getCreatedByName() + "," + feedback.getStatus() + ","
                        + (feedback.getItResponse() != null
                        ? feedback.getItResponse() : "") + ","
                        + (feedback.getRespondedBy() != null
                        ? feedback.getRespondedBy() : ""));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving feedbacks: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error closing the file: "
                            + e.getMessage());
                }
            }
        }
    }
}
