
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.Assert.*;

public class ITEmployeeTest {

    private ITEmployee itEmployee;
    private ArrayList<FeedBack> feedbackList;
    private FileHandler fileHandler;

    @Before
    public void setup() {
        itEmployee = new ITEmployee("E011", "Jane Doe");
        feedbackList = new ArrayList<FeedBack>();
        fileHandler = new FileHandler();
    }

    @Test
    public void RespondToUnsolvedIssue_StatusUpdatedTest() {
        feedbackList.add(new FeedBack("FB1", "Printer issue", "Test", "001", "Ali Ahmed"));
        Scanner scanner = new Scanner("1\nReplaced toner\n1\n");

        itEmployee.viewAndRespondToUnsolvedIssues(feedbackList, scanner, fileHandler);

        assertEquals("Solved", feedbackList.get(0).getStatus());
    }

    @Test
    public void RespondToUnsolvedIssue_ITResponseTest() {
        feedbackList.add(new FeedBack("FB1", "Printer issue", "Test", "001", "Ali Ahmed"));
        Scanner scanner = new Scanner("1\nReplaced toner\n1\n");

        itEmployee.viewAndRespondToUnsolvedIssues(feedbackList, scanner, fileHandler);

        assertEquals("Replaced toner", feedbackList.get(0).getItResponse());
    }

    @Test
    public void testFeedbackSetItResponse() {
        FeedBack feedback = new FeedBack("FB1", "Printer issue", "The printer is not working", "001", "Ali Ahmed");
        feedback.setItResponse("Fixed");
        assertEquals("Fixed", feedback.getItResponse());
    }

}
