import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test the hash function (you should throw this away for your project and write
 * your own tests)
 *
 * @author {Your Name Here}
 * @version {Put Something Here}
 */
public class HashTest extends TestCase {
    private Hash h;
    /**
     * Sets up the tests that follow.
     */
    public void setUp() {
        h = new Hash(5);
    }


    /**
     * Test the hash function
     */
    public void testh() {

        Hash myHash = new Hash(100);
        assertEquals(myHash.h("aaaabbbb", 101), 75);
        assertEquals(myHash.h("aaaabbb", 101), 1640219587 % 101);
    }
    
    public void testBasic() {
        h.insert("one");
        h.insert("two");
        h.insert("three");
        h.insert("four");
        
        h.tablePrint();  
        
//        System.out.println(h.h("aaaabbbb", 101));
    }
    
}
