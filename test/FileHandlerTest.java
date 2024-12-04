
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;

public class FileHandlerTest {
    
    private FileHandler fileHandler;
    
    @Before
    public void setup() {
        fileHandler = new FileHandler();
    }

    @Test
    public void LoadEmployees_FoundEmployee() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("employees_test.txt"));
        writer.write("001,GeneralEpmloyee,Ali Ahmed,ali.ahmed@company.com\n");
        writer.write("002,GeneralEpmloyee,Ali Ahmed,ali.ahmed@company.com\n");
        writer.close();

        fileHandler.loadEmployees("employees_test.txt");

        String[] employee1 = fileHandler.findUserById("002");
        assertNotNull(employee1);
    }
}

    

    

