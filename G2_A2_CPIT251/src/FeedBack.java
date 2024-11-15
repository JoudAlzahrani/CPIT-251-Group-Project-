
import java.time.LocalDateTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class FeedBack {
    private String employeeId; 
    private String description; 
    private LocalDateTime timeStamp; 

    // constructor to create Feedback object with employee ID and description
    public FeedBack(String employeeId, String description) {
        this.employeeId = employeeId; 
        this.description = description; 
        this.timeStamp = LocalDateTime.now(); 
    }

    // return feedback details 
    @Override
    public String toString() {
        return "employee: " + employeeId + "\nDescription: " + description + "\nTime: " + timeStamp + "\n";
    }

   
    public String getemployeeId() {
        return employeeId;
    }

    
    public String getDescription() {
        return description;
    }

   
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}



