import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

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
        // setup part
        String issueType = "Printer issue";
        String description = "Printer is not working";
        
        // call part
        String feedbackId = fileHandler.generateFeedbackId(feedbackList);
        FeedBack feedback = new FeedBack(feedbackId, issueType, description, employee.getId(), employee.getName());
        feedbackList.add(feedback);
        
        // assertion part
        assertEquals("Printer issue", feedback.getType());
    }

    @Test
    public void SubmitFeedback_TestIssueDescription() {
        // setup part
        String issueType = "Computer issue";
        String description = "Computer crashes frequently";

        // call part
        String feedbackId = fileHandler.generateFeedbackId(feedbackList);
        FeedBack feedback = new FeedBack(feedbackId, issueType, description, employee.getId(), employee.getName());
        feedbackList.add(feedback); // Add to the feedback list
        
        // assertion part
        assertEquals("Computer crashes frequently", feedback.getDescription());
    }

    @Test
    public void ViewFeedback_TestCreatedBy() {
        // setup part
        feedbackList.add(new FeedBack("FB001", "Printer issue", "Printer not working", "001", "Ahmed Mohammed"));
        boolean found = false;

        // call part
        for (FeedBack feedback : feedbackList) {
            if (feedback.getCreatedBy().equals(employee.getId())) {
                found = true;
                break;
            }
        }

        // assertion part
        assertTrue(found);
    }
}
