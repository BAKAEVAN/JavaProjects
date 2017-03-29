/**
 * Created by B10409038 on 2017/3/25.
 */

import java.util.Scanner;

public class ABGuessLauncher {
    public static void main(String[] args) {
        boolean end = false;
        do {
            ABGuess abGuess = new ABGuess();
            System.out.println("********* 猜數字遊戲 *********");
            System.out.print("正確答案: ");
            abGuess.displayAnswer();
            System.out.println("********** 遊戲開始 **********");
            int A = 0, B = 0, times = 0;
            Scanner sc = new Scanner(System.in);
            do {
                A = 0;
                B = 0;
                times++;
                System.out.print("請輸入您猜的數字: ");
                String guess = sc.next();
                int[] input = new int[4];//ASCII code transform
                for (int n = 0; n <= 3; n++) {
                    input[n] = (int) guess.charAt(n) - 48;
                }
                if (abGuess.detection_input_type(input))
                    continue;
                if (abGuess.detection_input_repeat(input))
                    continue;
                for (int i = 0; i <= 3; i++) {
                    if (input[i] == abGuess.getAnswer()[i])
                        A++;
                    if (input[i] == abGuess.getAnswer()[0] ||
                            input[i] == abGuess.getAnswer()[1] ||
                            input[i] == abGuess.getAnswer()[2] ||
                            input[i] == abGuess.getAnswer()[3])
                        B++;
                }
                B -= A;
                if (A != 4)
                    System.out.printf("%dA%dB\n", A, B);
                else
                    System.out.printf("%dA%dB\n恭喜您答對了 !\n", A, B);
            } while (A != 4);
            System.out.println("********** 遊戲結束 **********");
            System.out.printf("您總共猜了 %d 次!\n", times);
            System.out.println("******* 在玩一次(Y/N)? *******");
            String Yes_No = sc.next();
            if (Yes_No.equals("N")||Yes_No.equals("n"))
                end = true;
        } while (!end);
    }
}
