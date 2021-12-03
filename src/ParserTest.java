import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author g23
 * @version Dec 3, 2021
 *
 */
public class ParserTest extends student.TestCase {

    private Parser p;
    private Hash h;
    
    public void setUp() {
        File i = new File("src/sampleInput.txt");
//        this.p = new Parser(h, i);
    }
    
    public void testRun() throws FileNotFoundException {
        this.p.parse();
    }
}   
