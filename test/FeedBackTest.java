

import org.junit.Test;
import static org.junit.Assert.*;

public class FeedBackTest {
    
    @Test
    public void FeedbackCreationTest_VerifyByID() {
        FeedBack feedback = new FeedBack("FB1", "Printer issue", "Printer is not working", "001", "Ali Ahmed");
        assertEquals("FB1", feedback.getId());
    }
    
}
