

import org.junit.Test;
import static org.junit.Assert.*;

public class FeedBackTest {
    
    @Test
    public void FeedbackCreationTest_VerifyByID() {
        FeedBack feedback = new FeedBack("FB1", "Printer issue", "Printer is not working", "001", "Ali Ahmed");
        assertEquals("FB1", feedback.getId());
    }
     @Test
    public void FeedbackCreationTest_VerifyByType() {
        FeedBack feedback = new FeedBack("FB1", "Printer issue", "Printer is not working", "001", "Ali Ahmed");
        assertEquals("Printer issue", feedback.getType());
    }
    
    @Test
    public void FeedbackCreationTest_Description() {
        FeedBack feedback = new FeedBack("FB1", "Printer issue", "Printer is not working", "001", "Ali Ahmed");
        assertEquals("Printer is not working", feedback.getDescription());
    }
    
    @Test
    public void FeedbackCreationTest_CreatedBy() {
        FeedBack feedback = new FeedBack("FB1", "Printer issue", "Printer is not working", "001", "Ali Ahmed");
        assertEquals("001", feedback.getCreatedBy());
    }

}
