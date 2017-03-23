
import java.util.Scanner;
public class CaesarTest {
    public static void main(String[] args) {
    // main method begins execution of Java application
       Scanner scanner=new Scanner(System.in);
       String input;												                        // create a String object
       System.out.print("Plaintext:");
       input=scanner.next();										                    // obtain user input=Plaintext
       System.out.print("Key:");
       Caesar caesar=new Caesar(input,scanner.nextInt());			      //obtain user input=Key,and create a Caesar object
       System.out.printf("Ciphertext:%s", caesar.getCiphertext());	//display Ciphertext
    }
    
}
