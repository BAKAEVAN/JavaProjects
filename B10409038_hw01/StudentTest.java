import java.util.Scanner;

public class StudentTest {
// main method begins execution of Java application

    public static void main(String[] args) {
        Student student1 = new Student();   // create Student object
        student1.set_Name(args[0]);         // set student1 name to args[0]
        student1.set_ID(args[1]);           // set student1 ID to args[1]
        student1.set_Class(args[2]);        // set student1 class to args[2]
        Student student2 = new Student();   // create Student object
        // create Scanner to obtain input from command window
        Scanner input = new Scanner(System.in);
        System.out.print("Name:");
        String theName = input.nextLine();  // obtain user input
        student2.set_Name(theName);         // set student2 name to theName
        System.out.print("ID:");
        String theID = input.nextLine();    // obtain user input
        student2.set_ID(theID);             // set student2 ID to theID
        System.out.print("Class:");
        String theClass = input.nextLine(); // obtain user input
        student2.set_Class(theClass);       // set student2 class to theClass
        System.out.println("----------Student1----------");
        student1.displaystudent();          // display student1 information
        System.out.println("----------Student2----------");
        student2.displaystudent();          // display student2 information
    }
}       // end class StudentTest
