public class Student {

    private String Name;    // instance that student name
    private String ID;      // instance that student ID
    private String Class;   // instance that student class
    // set the student name
    public void set_Name(String name) {
        Name = name;
    }
    // end method set_Name
    // set the student ID
    public void set_ID(String id) {
        ID = id;
    }
    // end method set_ID
    // set the student class
    public void set_Class(String theclass) {
        Class = theclass;
    }
    // end method set_Class
    // disply the student information
    public void displaystudent() {
        System.out.printf("Name:%s\n", Name);
        System.out.printf("ID:%s\n", ID);
        System.out.printf("Class:%s\n", Class);
    }
    // end method displaystudent
}   // end class Student
