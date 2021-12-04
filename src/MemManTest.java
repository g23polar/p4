import java.io.FileNotFoundException;

import student.TestCase;

/**
 * Test the main function (you should throw this away for your project and write
 * your own tests)
 * 
 * @author {Your Name Here}
 * @version {Put Something Here}
 */
public class MemManTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing Here
    }


    /**
     * Get code coverage of the class declaration.
     * @throws FileNotFoundException 
     */
    public void testRInit() throws FileNotFoundException {
        MemMan manager = new MemMan();
        assertNotNull(manager);
        String[] args = new String[3];
        args[0] = "1024";
        args[1] = "5";
        args[2] = "src/mytest.txt";
//        args[2] = "src/sampleInput.txt";
//        System.out.println("main before");
        MemMan.main(args);
//        System.out.println("main after");
    }
}
