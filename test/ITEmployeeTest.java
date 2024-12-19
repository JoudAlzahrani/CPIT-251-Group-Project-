import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class ITEmployeeTest {

    private ITEmployee itEmployee;
    private ArrayList<FeedBack> feedbackList;
    private FileHandler fileHandler;

    @Before
    public void setup() {
        itEmployee = new ITEmployee("011", "Jane Doe");
        feedbackList = new ArrayList<FeedBack>();
        fileHandler = new FileHandler();
    }

    @Test
    public void StatusUpdatedTest() {
        // Setup: Add unsolved feedback
        FeedBack feedback = new FeedBack("FB1", "Printer issue", "Test", "001", "Ali Ahmed");
        feedbackList.add(feedback);

        // Call: Directly update the feedback's status as part of the test logic
        feedback.setStatus("Solved");
        feedback.setItResponse("Replaced toner");

        // Assert: Verify that the feedback's status is updated correctly
        assertEquals("Solved", feedbackList.get(0).getStatus());
    }

    @Test
    public void StatusUpdatedTest2() {
        // Setup: Add unsolved feedback
        FeedBack feedback = new FeedBack("FB1", "Printer issue", "Test", "001", "Ali Ahmed");
        feedbackList.add(feedback);

        // Call: Directly update the feedback's status as part of the test logic
        feedback.setStatus("Unsolved");
        feedback.setItResponse("Replaced toner");

        // Assert: Verify that the feedback's status is updated correctly
        assertEquals("Unsolved", feedbackList.get(0).getStatus());
    }

    @Test
    public void ITResponseTest() {
        // Setup: Add unsolved feedback
        FeedBack feedback = new FeedBack("FB1", "Printer issue", "Test", "001", "Ali Ahmed");
        feedbackList.add(feedback);

        // Call: Directly set the IT response
        feedback.setItResponse("Replaced toner");

        // Assert: Verify that the IT response is updated correctly
        assertEquals("Replaced toner", feedbackList.get(0).getItResponse());
    }
}
