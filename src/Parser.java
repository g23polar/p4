import java.io.*;
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
    
    public Parser(Pool p, Hash h, File i) {
        this.pool = p;
        this.hash = h;
        this.input = i;
    }
    
    public void parse() throws FileNotFoundException {
        Scanner scanner = new Scanner(this.input);
        while(scanner.hasNext()) {
            
            String line = scanner.nextLine().strip();
//            System.out.println("line = " +line);
            if(line.length() == 0) {
                continue;
            }
            String[] words = line.split("\\s+");
            
            if(words.length == 0) {
                continue;
            }
            switch(words[0]) {
                case "add":
//                    System.out.println("switch add");
                    String name = "";
                    for(int i = 1; i < words.length; i++) {
                        name += words[i]+" ";
                    }
                    name = name.substring(0, name.length()-1);
                    this.hash.insert(name);
                    break;
                
                case "print":
                    this.hash.tablePrint();
//                    if(words[1] == "hashtable") {
//                        System.out.println("print table");
//                        
//                    }
//                    else if(words[1] == "blocks") {
//                        
//                    }
                    break;
            }
//            for(String word: words) {
//                System.out.print(word + "--");
//            }
//            System.out.println();
//            if(!approveCommand(words)) {
//                continue;
//            }
            
            
        }
    }

    private boolean approveCommand(String[] words) {
        // TODO Auto-generated method stub
        return false;
    }   
}
