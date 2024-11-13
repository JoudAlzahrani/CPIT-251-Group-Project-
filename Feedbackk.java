
package feedback;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Feedback {
private String userId; // هنا نخزن رقم المستخدم
private String description; // هنا نخزن وصف الملاحظات
private String timestamp; // هنا نخزن الوقت اللي تم فيه تقديم الملاحظة
public Feedback(String userId, String description) {
this.userId = userId; //  رقم المستخدم
this.description = description; //  وصف الملاحظة
this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());} // نسجل الوقت الحالي

public String getEntry() {
return userId + "|" + description + "|" + timestamp;}} // نرجع المعلومة بشكل مرتب

public class Feedbackk {
private static final String FILE_NAME = "C:\\Users\\rubak\\Downloads\\feedbackK.txt";

//هنا مسار الملف اللي بنخزن فيه الملاحظات
// سووا ملف في جهازكم وسموه زيي  feedbackK  
//حطوا الباث من جهازكم 
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in); // نستخدم سكانر عشان نقرا المدخلات من المستخدم
while (true) {
System.out.println("1. Submit Feedback"); // خيار تقديم الملاحظات
System.out.println("2. Exit"); // خيار الخروج
System.out.print("Choose an option: "); // نطلب من المستخدم اختيار
int choice = scanner.nextInt(); // نقرأ الخيار
scanner.nextLine(); 
if (choice == 1) { // إذا اختار تقديم ملاحظة
System.out.print("Enter your User ID: "); // نطلب رقم المستخدم
String userId = scanner.nextLine(); // نقرأ رقم المستخدم
System.out.print("Enter your feedback: "); // نطلب الملاحظة
String feedbackDescription = scanner.nextLine(); // نقرأ الملاحظة
submitFeedback(new Feedback(userId, feedbackDescription)); // نقدم الملاحظة
} else if (choice == 2) { // إذا اختار الخروج
System.out.println("Exiting..."); // نطبع رسالة الخروج
scanner.close(); // نقفل السكانر
return; // نرجع للخارج
} else {
System.out.println("Invalid choice, please try again.");}}} // إذا كان الخيار غير صحيح


private static void submitFeedback(Feedback feedback) {
try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
writer.write(feedback.getEntry());
writer.newLine();
System.out.println("Feedback submitted successfully."); // رسالة نجاح
} catch (IOException e) {
System.err.println("Error writing to file: " + e.getMessage());}}} // رسالة الخطأ
