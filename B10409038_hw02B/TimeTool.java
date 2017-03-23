import java.util.*;

public class TimeTool {

    private int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void showCurrentTime() {
        Date now = new Date();
        System.out.println(now);
        System.out.println("");
    }

    public static boolean isLeapYear(int year) {
        boolean isLeapYear = false;
        if ((year % 4) == 0 && (year % 100) != 0 || (year % 400) == 0) {
            isLeapYear = true;
        }
        return isLeapYear;
    }

    public int weekday(int year, int month, int day) {
        int sum = 0;
        for (int i = 1; i < year; i++) {
            if (isLeapYear(i)) {
                sum += 366;
            } else {
                sum += 365;
            }
        }
        if (isLeapYear(year)) {
            months[1] = 29;
        } else {
            months[1] = 28;
        }
        for (int i = 0; i < month - 1; i++) {
            sum += months[i];
        }
        sum += day;
        return sum % 7;
    }

    public void calendar(int year, int month) {
        int[] cal = new int[42];
        int date = 1;
        int line = 0;
        System.out.printf("\n%4s%4s%4s%4s%4s%4s%4s\n", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
        if (isLeapYear(year)) {
            months[1] = 29;
        } else {
            months[1] = 28;
        }
        for (int i = 0; i < 42; i++) {
            line++;
            if (i == weekday(year, month, 1)) {
                for (int j = i; j < months[month - 1] + i; j++) {
                    cal[j] = date;
                    date++;
                }
            }
            if (cal[i] == 0) {
                System.out.printf("    ");
            } else {
                System.out.printf("%4s", Integer.toString(cal[i]));
            }
            if (line % 7 == 0) {
                System.out.println("");
            }
        }
    }
}
