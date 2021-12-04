import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author g23
 * @version Dec 3, 2021
 *
 */
public class Parser {

    private File input;
    private Hash hash;
    private Pool pool;

    ArrayList<String> mlist;

    public Parser(Pool p, Hash h, File i) {
        this.pool = p;
        this.hash = h;
        this.input = i;
        this.mlist = new ArrayList<String>();
    }

    public void parse() throws FileNotFoundException {
        Scanner scanner = new Scanner(this.input);
        while (scanner.hasNext()) {

            String line = scanner.nextLine().strip();
            // System.out.println("line = " +line);
            if (line.length() == 0) {
                continue;
            }
            String[] words = line.split("\\s+");

            if (words.length == 0) {
                continue;
            }
            switch (words[0]) {
                case "add" :
                    // System.out.println("switch add");
                    String name = "";
                    for (int i = 1; i < words.length; i++) {
                        name += words[i] + " ";
                    }
                    name = name.substring(0, name.length() - 1);

                    if (!this.mlist.contains(name)) {
                        this.hash.insert(name);
                        this.mlist.add(name);
                        System.out.println("|" + name + "|"
                                + " has been added to the Name database.");

                    }
                    else {
                        System.out.println("|" + name + "|"
                                + " duplicates a record already in the Name database.");
                    }
                    break;

                case "print" :
                    this.hash.tablePrint();
                    // if(words[1] == "hashtable") {
                    // System.out.println("print table");
                    //
                    // }
                    // else if(words[1] == "blocks") {
                    //
                    // }
                    break;

                case "delete" :
                    String name2 = "";
                    for (int i = 1; i < words.length; i++) {
                        name2 += words[i] + " ";
                    }
                    name2 = name2.substring(0, name2.length() - 1);

                    if (!this.mlist.contains(name2)) {
                        System.out.println("|" + name2 + "|"
                                + " not deleted because it does not exist in the Name database.");
                    }
                    else {
                        mlist.remove(name2);
                        this.hash.remove(name2);
                        System.out.println("|" + name2 + "|"
                                + " has been deleted from the Name database.");
                    }
                    
                    break;
                    
                case "end":
                    scanner.close();
                    System.exit(0);
                    break;

            }
        }
        scanner.close();
    }

    private boolean approveCommand(String[] words) {
        // TODO Auto-generated method stub
        return false;
    }
}
