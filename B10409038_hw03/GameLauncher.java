/**
 * Created by B10409038 on 2017/3/24.
 */

import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {
        boolean end = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("**********瞦计笴栏**********");
                System.out.printf("瞦计絛瞅程: ");
                int min = sc.nextInt();
                System.out.print("瞦计絛瞅程: ");
                int max = sc.nextInt();
                System.out.printf("瞦计Ω计: ");
                int times = sc.nextInt();
                if (min <= 0 || max <= 0 || times <= 0 || max <= min) {
                    System.out.print("块岿粇!\n" +
                            "程程Ω计斗タ俱计\n" +
                            "程斗程\n\n");
                    continue;
                }
                Guess guess = new Guess(min, max, times);
                System.out.println("********** 笴栏秨﹍ **********");
                int[] record = new int[times + 1];
                int actual_times = times;
                for (int i = 1; i <= times; i++) {
                    System.out.printf("计絛瞅: %d°%d\n", min, max);
                    System.out.printf("眤瞦计: ");
                    int input = sc.nextInt();
                    record[i] = input;
                    if (guess.Game_Start(min, max, input)) {
                        actual_times = i;
                        break;
                    } else {
                        min=guess.getMin();
                        max=guess.getMax();
                    }
                }
                System.out.println("********** 笴栏挡 **********");
                for (int i = 1; i <= actual_times; i++) {
                    System.out.printf("材 %d 瞦: %d\n", i, record[i]);
                }
                System.out.println("---");
                System.out.printf("瞦计 %d Ω\n", times);
                System.out.printf("眤羆瞦 %d Ω\n", actual_times);
                System.out.printf("タ絋计: %d\n", guess.getAnswer());
                System.out.println("******* Ω<Y/N>? *******");
                String Yes_No = sc.next();
                if (Yes_No.equals("N")||Yes_No.equals("n"))
                    end = true;
            } catch (Exception e) {
                System.out.print("块岿粇!\n" +
                        "叫猔種块戈琌Τ粇\n\n");
            }
        } while (!end);
    }
}

