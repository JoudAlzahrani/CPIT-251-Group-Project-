import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static FileHandler instance;
    private String[][] employees = new String[20][4];
    private int employeeCount = 0;

    
    
    private FileHandler() {}

    public static FileHandler getInstance() {
        if (instance == null) {
            instance = new FileHandler();
        }
        return instance;
    }


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

    public void saveFeedBacks(ArrayList<FeedBack> feedbackList) {
    BufferedWriter writer = null;
    try {
        writer = new BufferedWriter(new FileWriter("feedbacks.txt"));
        for (FeedBack feedback : feedbackList) {
            writer.write(feedback.getId() + "," + feedback.getType() + "," + feedback.getDescription() + "," +
                    feedback.getCreatedBy() + "," + feedback.getCreatedByName() + "," + feedback.getStatus() + "," +
                    (feedback.getItResponse() != null ? feedback.getItResponse() : "") + "," +
                    (feedback.getRespondedBy() != null ? feedback.getRespondedBy() : ""));
            writer.newLine();
        }
    } catch (IOException e) {
        System.out.println("Error saving feedbacks: " + e.getMessage());
    } finally {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println("Error closing the file: " + e.getMessage());
            }
        }
    }
}

    public void saveResponse(FeedBack feedback, String itId, String itName) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("responses.txt", true));
            writer.write("Feedback ID: " + feedback.getId() + ", Type: " + feedback.getType() + ", Response: " + feedback.getItResponse() +
                    ", IT: " + itName + " (ID: " + itId + ")");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving response: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error closing the file: " + e.getMessage());
                }
            }
        }
    }
    
    public void readResponsesWithStatus(ArrayList<FeedBack> feedbackList) {
    BufferedReader reader = null;
    try {
        reader = new BufferedReader(new FileReader("responses.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line); 
            String feedbackId = line.split(",")[0].split(":")[1].trim();
            FeedBack matchingFeedback = null;
            for (FeedBack feedBack : feedbackList) {
                if (feedBack.getId().equals(feedbackId)) {
                    matchingFeedback = feedBack;
                    break;
                }
            }

            if (matchingFeedback != null) {
                System.out.println("Status: " + matchingFeedback.getStatus());
            } else {
                System.out.println("Status: Unknown");
            }
        }
    } catch (IOException e) {
        System.out.println("No previous responses found.");
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
}
