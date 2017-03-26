/**
 * Created by B10409038 on 2017/3/25.
 */

public class ABGuess {
    private int[] answer;

    public ABGuess() {
        answer = answer_make();
    }

    public int[] answer_make() {
        int[] answer = new int[4];
        answer[0] = (int) (Math.random() * 10);
        do {
            answer[1] = (int) (Math.random() * 10);
        } while (answer[1] == answer[0]);
        do {
            answer[2] = (int) (Math.random() * 10);
        } while (answer[2] == answer[1] || answer[2] == answer[0]);
        do {
            answer[3] = (int) (Math.random() * 10);
        } while (answer[3] == answer[2] || answer[3] == answer[1] || answer[3] == answer[0]);
        return answer;
    }

    public void displayAnswer() {
        for (int e : answer) {
            System.out.print(e);
        }
        System.out.println("");
    }

    public int[] getAnswer() {
        return answer;
    }

    public boolean detection_input_type(int[] input) {
        boolean pop = false;
        for (int k = 0; k <= 3; k++) {
            if (input[k] < 0 || input[k] > 9) {
                pop = true;
                break;
            }
        }
        if (pop)
            System.out.print("型別錯誤!\n請輸入數字0~9!\n0A0B\n");
        return pop;
    }

    public boolean detection_input_repeat(int[] input) {
        boolean repeat = false;
        for (int i = 0; i <= 3; i++) {
            for (int k = i + 1; k <= 3; k++) {
                if (input[i] == input[k]) {
                    repeat = true;
                    break;
                }
            }
            if (repeat)
                break;
        }
        if (repeat)
            System.out.print("請輸入 4 個不重複數字!\n0A0B\n");
        return repeat;
    }
}





