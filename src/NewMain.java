/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// testing of pull 
// lina 
// يارب يزبط
//الحمدلله 
//joud_test_ يارببب
// استغفرالله
// لا اله الا الله

import java.util.*;

public class NewMain {

    /**
     * @param args the command line arguments
     */
    private static final String EMPLOYEE_FILE = "employees.txt.txt";
    private static final String COMMENT_FILE = "comments.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter your ID: ");
            String id = scanner.nextLine().trim();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        
         String employeeInfo = findEmployeeById(id);
            if (employeeInfo == null) {
                System.out.println("Invalid ID. Please try again.");
                return;
            }
 
           
            
        } 
            
    }
   
