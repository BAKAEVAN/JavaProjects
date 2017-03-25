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
            System.out.println("��J���~! �W�X�d��!");
        } else {
            if (input > answer) {
                System.out.println("�q���F! �z�q���Ʀr�񵪮פj!");
                max = input;
            } else if (input < answer) {
                System.out.println("�q���F! �z�q���Ʀr�񵪮פp!");
                min = input;
            } else {
                System.out.println("���߱z�q��F!");
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



