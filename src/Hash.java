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

    public boolean insert(String val) {

        if ((this.size) * 2 >= this.capacity) {
            /**
             * double, reinsert and add new
             */
            // System.out.println("rehash");
            this.rehash(val);
            this.size++;
            return true;
        }
        
        else {
            this.size++;
             System.out.println("basic add");
             System.out.println("val = " + val);
             System.out.println("cap = " + this.capacity);
            return this.basicInsert(this.table, val, this.capacity);
        }

    }

    /**
     * with quadratic probing logic
     * 
     * @param s
     *            string to add
     * @param c
     *            current capacity
     */
    private boolean basicInsert(String[] t, String s, int c) {

        if (s == null) {
            return false;
        }

        int home = this.h(s, c + 1);
        boolean inserted = false;
        if (t[home] == null) {
            t[home] = s;
            inserted = true;
            System.out.print("hash add > " + s);
            System.out.println(" at " + home);
        }
        else {
             System.out.println("occupied");
            while (true) {
                // System.out.println("original is " + home);
                home = (home * home) % c;
                // System.out.println("Squaring is " + home);
                if (t[home] == null) {
                    t[home] = s;
                    inserted = true;
                    break;
                }
            }
        }
        System.out.println("hash add ret > " + inserted);
        return inserted;
    }

    private void rehash(String addition) {
        System.out.println("rehashing and adding " + addition);
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
        System.out.println("Total records: " + this.size);
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

    public void remove(String string) {
//        System.out.println("hash remove > " + string);
        for (int i = 0; i < this.capacity; i++) {
            if (string.equals(this.table[i])) {
//                System.out.println("found > " + string);
                this.table[i] = null;
                this.size--;
                break;
            }
        }

    }
}
