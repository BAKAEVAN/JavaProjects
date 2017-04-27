import java.util.Scanner;

/**
 * Created by B10409038 on 2017/4/27.
 */

public class TimeLengthTest {
    public static void main(String[] args) {
        TimeLength timeLength = new TimeLength();
        Scanner sc = new Scanner(System.in);
        String input = new String();
        String time = new String();
        do {
            showMenu();/** 顯示 menu*/
            input = sc.next();/** 取得使用者輸入*/
            if (input.matches("[0-3]{1}")) {
                switch (input) {
                    case "1":
                        System.out.print("Please enter a time <seconds or hh:mm:ss>: ");
                        time = sc.next();
                        /**
                         * 輸入條件:
                         * 1. 輸入秒數, 可以輸入正整數或負整數
                         * 2. 輸入時、分和秒, 必須配合正規化表示法(hh:mm:ss)
                         */
                        if (time.matches("[-]?\\d+")) {
                            timeLength.setSec(Integer.parseInt(time));
                            System.out.printf("Time:%d\n\n", timeLength.getSec());
                        } else if (time.matches("[-]?\\d{2}:[0-5]{1}[0-9]{1}:[0-5]{1}[0-9]{1}")) {
                            timeLength.String_process_set(time);
                            System.out.printf("Time:%s\n\n", timeLength.getStrTime());
                        } else
                            System.out.println("Please enter a valid number.\n");
                        break;
                    case "2":
                        System.out.print("Please enter a time <seconds or hh:mm:ss>: ");
                        time = sc.next();
                        /**
                         * 輸入條件:
                         * 1. 輸入秒數, 可以輸入正整數或負整數
                         * 2. 輸入時、分和秒, 必須配合正規化表示法(hh:mm:ss)
                         */
                        if (time.matches("[-]?\\d+")) {
                            timeLength.adjustSec(Integer.parseInt(time));
                            System.out.printf("Time:%d\n\n", timeLength.getSec());
                        } else if (time.matches("[-]?\\d{2}:[0-5]{1}[0-9]{1}:[0-5]{1}[0-9]{1}")) {
                            timeLength.String_process_adjust(time);
                            System.out.printf("Time:%s\n\n", timeLength.getStrTime());
                        } else
                            System.out.println("Please enter a valid number.\n");
                        break;
                    case "3":
                        System.out.printf("The current length of time <seconds>: %d\n", timeLength.getSec());
                        System.out.printf("The current length of time <hh:mm:ss>: %s\n\n", timeLength.getStrTime());
                        break;
                }
            } else
                System.out.println("Please enter a valid number.\n");
        } while (!input.equals("0"));
    }

    public static void showMenu() {
        System.out.println("***Convert Length of Time***");
        System.out.println("1) Set a length of time.");
        System.out.println("2) Adjust the length of time.");
        System.out.println("3) Show the length of time in different units.");
        System.out.println();
        System.out.print("Please enter a number in [1,2,3,0]: ");
    }
}
