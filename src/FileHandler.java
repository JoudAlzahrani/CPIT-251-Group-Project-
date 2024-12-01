
import java.io.*;
import java.util.ArrayList;


public class FileHandler {
   private String[][] employees = new String[20][4]; 
   private int employeeCount = 0;
   
   
   public String generateFeedbackId(ArrayList<Feedback> feedbackList) { 
       int maxId = 0;
       
       for (Feedback feedback : feedbackList) {
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
reader = new BufferedReader(new FileReader(fileName)); String line;
while ((line = reader.readLine()) != null) {
   String[] parts = line.split(","); employees[employeeCount][0] = parts[0].trim(); // ID 
   employees[employeeCount][1] = parts[1].trim(); // Role
   employees[employeeCount][2] = parts[2].trim(); // Name
   employees[employeeCount][3] = parts[3].trim(); // Email 
   employeeCount++;
            }
         } catch (IOException e) {
         System.out.println("Error reading employees file: " +
                e.getMessage());
               } finally {
                    if (reader != null) {
                    try {
                    reader.close();
                  }catch (IOException e){
                    System.out.println("Error closing the file: " + e.getMessage());
                    }
                }
        } 
    }
}
          
          
