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
// تجربة لينا 

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class NewMain {

   
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
 
        String[] details = employeeInfo.split(",");
        String role = details[1];
        String name = details[2];

         if ("staff".equalsIgnoreCase(role)) {
                handleStaff(scanner, id, name);
          } 
         else if ("it".equalsIgnoreCase(role)) {
                handleIT(scanner);
            } 
         else {
                System.out.println("Unknown role. Access denied.");}
    }
    
   
private static String findEmployeeById(String id) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(EMPLOYEE_FILE));
    for (String line : lines) {
        if (line.startsWith(id + ",")) {
            return line;
        }
    }
    return null;
}

    private static void handleIT(Scanner scanner) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
   
