/**
 * Stub for hash table class. Extend with your code, and update this docblock
 *
 * @author g23, avim
 * @version init
 */

public class Hash {

    private int size;
    private int capacity;
    private String[] table;

    /**
     * Create a new Hash object.
     * 
     */
    public Hash(int c) {
        this.capacity = c;
        this.table = new String[c + 1];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    public void insert(String val) {
        System.out.println("inserting val = " + val);

        if ((this.size + 1) * 2 >= this.capacity) {
            /**
             * double, reinsert and add new
             */
            // System.out.println("rehash");
            this.rehash(val);
            return;
        }
        else {
            // System.out.println("basic add");
            this.basicInsert(this.table, val, this.capacity);
        }

        this.size++;

    }

    /**
     * with quadratic probing logic
     * 
     * @param s
     *            string to add
     * @param c
     *            current capacity
     */
    private void basicInsert(String[] t, String s, int c) {
        if (s == null) {
            return;
        }
        System.out.println("s = " + s);
        int home = this.h(s, c + 1);

        if (t[home] == null) {
            t[home] = s;
        }
        else {
            // System.out.println("occupied");
            while (true) {
                // System.out.println("original is " + home);
                home = (home * home) % c;
                // System.out.println("Squaring is " + home);
                if (t[home] == null) {
                    t[home] = s;
                    break;
                }
            }
        }
    }

    private void rehash(String addition) {

        this.capacity = (2 * this.capacity);
        String[] newTable = new String[this.capacity + 1];

        for (String s : this.table) {
            // basic home insertion

            this.basicInsert(newTable, s, this.capacity);
        }
        this.basicInsert(newTable, addition, this.capacity);

        this.table = newTable;
    }

    public void tablePrint() {
        int idx = 0;
        for (String s : table) {
            if (s != null) {
                System.out.println("|" + s + "|" + idx);
            }
            idx++;
        }
    }

    /**
     * Compute the hash function. Uses the "sfold" method from the OpenDSA
     * module on hash functions
     *
     * @param s
     *            The string that we are hashing
     * @param m
     *            The size of the hash table
     * @return The home slot for that string
     */
    // You can make this private in your project.
    // This is public for distributing the hash function in a way
    // that will pass milestone 1 without change.
    public int h(String s, int m) {
        int intLength = s.length() / 4;
        long sum = 0;
        for (int j = 0; j < intLength; j++) {
            char[] c = s.substring(j * 4, (j * 4) + 4).toCharArray();
            long mult = 1;
            for (int k = 0; k < c.length; k++) {
                sum += c[k] * mult;
                mult *= 256;
            }
        }

        char[] c = s.substring(intLength * 4).toCharArray();
        long mult = 1;
        for (int k = 0; k < c.length; k++) {
            sum += c[k] * mult;
            mult *= 256;
        }

        return (int) (Math.abs(sum) % m);
    }
}
