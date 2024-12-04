
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeTest {

    private Employee employee;
    private ArrayList<FeedBack> feedbackList;
    private FileHandler fileHandler;

    @Before
    public void setup() {
        employee = new Employee("E001", "John Doe");
        feedbackList = new ArrayList<FeedBack>();

        fileHandler = new FileHandler();
    }

    @Test
    public void SubmitFeedback_TestIssueType() {
        Scanner scanner = new Scanner("1\nPrinter is not working\n");
        employee.submitFeedback(feedbackList, scanner, fileHandler);
        FeedBack feedback = feedbackList.get(0);
        assertEquals("Printer issue", feedback.getType());
    }

}
