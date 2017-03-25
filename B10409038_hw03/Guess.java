/**
 * Created by B10409038 on 2017/3/24.
 */
public class Guess {
    private int min, max, times, answer;

    public Guess(int input_min, int input_max, int input_times) {
        min = input_min;
        max = input_max;
        times = input_times;
        answer = (int) (Math.random() * (max - min + 1) + min);
    }

    public boolean Game_Start(int Min, int Max, int input) {
        boolean bingo = false;
        if (input < min || input > max) {
            System.out.println("輸入錯誤! 超出範圍!");
        } else {
            if (input > answer) {
                System.out.println("猜錯了! 您猜的數字比答案大!");
                max = input;
            } else if (input < answer) {
                System.out.println("猜錯了! 您猜的數字比答案小!");
                min = input;
            } else {
                System.out.println("恭喜您猜對了!");
                bingo = true;
            }
        }
        return bingo;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getAnswer() {
        return answer;
    }
}



