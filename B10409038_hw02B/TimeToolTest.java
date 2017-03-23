import java.util.*;

public class TimeToolTest {

    public static void main(String[] args) {
        TimeTool timetool = new TimeTool();
        boolean end = false;
        do {
	   try {
                  System.out.print("***Main Menu***\n"
                        + "1) Show the Current Time\n"
                        + "2) Check for Leap Year\n"
                        + "3) Show the Calendar\n"
                        + "0) Exit\n\n"
                        + "Please enter a number in [1,2,3,0]: ");
                Scanner input = new Scanner(System.in);
                int num = input.nextInt();
                switch (num) {
                    case 1:
                        TimeTool.showCurrentTime();
                        break;
                    case 2:
                        System.out.print("Plase enter the number of year : ");
                        int year = input.nextInt();
                        if (year < 1) {
                            System.out.println("Input error!\n");
                        } else {
                            if (TimeTool.isLeapYear(year)) {
                                System.out.println(year + " is a leap year .\n");
                            } else {
                                System.out.println(year + " is not a leap year .\n");
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Year: ");
                        int cal_year = input.nextInt();
                        System.out.print("Month: ");
                        int cal_month = input.nextInt();
                        if (cal_year < 1 || cal_month < 1 || cal_month > 12) {
                            System.out.println("Input error!\n");
                        } else {
                            timetool.calendar(cal_year, cal_month);
                        }
                        break;
                    case 0:
                        end = true;
                        System.out.println("The program is coming to an end.\n");
                        break;
                    default:
                        System.out.println("Input error!\n");
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Input error!\n");
            }
        } while (!end);
    }
}
