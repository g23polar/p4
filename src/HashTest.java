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
    public void testH() {

        Hash myHash = new Hash(100);
        assertEquals(myHash.h("aaaabbbb", 101), 75);
        assertEquals(myHash.h("aaaabbb", 101), 1640219587 % 101);
    }
    
    /**
     * Test the basicInsert function
     */
    public void testBasic2() {
//       Hash myHash2 = new Hash(null);
//       myHash2.insert("a");
       //t=new String[11], s = val, c = 10
       
    }
    
    
    
    /**
     * Tests everything 
     */
    public void testInclusive() {
        assertEquals(0, h.size());
        assertEquals(5, h.capacity());
        h.insert("one");
        h.insert("two");
        h.insert("three");
    }
    
    /**
     * Test the basicInsert function
     */
    public void testBasic() {
        h.insert("one");
        h.insert("two");
        h.insert("three");
        h.insert("four");
        
        h.tablePrint();  
        
//        System.out.println(h.h("aaaabbbb", 101));
    }
    
    public void testSize() {
        assertEquals(0, h.size());
        h.insert("1");
        assertEquals(1, h.size());
        h.insert("2");
        h.insert("3");
        assertEquals(3, h.size());
        h.tablePrint();
    }
    
}
