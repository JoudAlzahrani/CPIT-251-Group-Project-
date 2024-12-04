
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
        employee = new Employee("001", "Ahmed Mohammed");
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

    @Test
    public void SubmitFeedback_TestIssueDescription() {
        Scanner scanner = new Scanner("3\nComputer crashes frequently\n");
        employee.submitFeedback(feedbackList, scanner, fileHandler);
        FeedBack feedback = feedbackList.get(0);

        assertEquals("Computer crashes frequently", feedback.getDescription());
    }

    @Test
    public void ViewFeedback_TestCreatedBy() {
        feedbackList.add(new FeedBack("FB001", "Printer issue", "Printer not working", "001", "Ahmed Mohammed"));

        boolean found = false;
        for (FeedBack feedback : feedbackList) {
            if (feedback.getCreatedBy().equals("001")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

}
