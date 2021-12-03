import java.util.LinkedList;

/**
 * @author g23
 * @version Dec 3, 2021
 *
 */
public class Pool {
    
    private byte[] masterlist;
    
    private LinkedList<Integer> freelist;
    
    public Pool(int size) {
        freelist = new LinkedList<Integer>();
        masterlist = new byte[size];
    }
    
    public boolean insert() {
        return false;
    }
    
}
