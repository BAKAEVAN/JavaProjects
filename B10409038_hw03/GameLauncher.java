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
                System.out.println("**********�q�Ʀr�C��**********");
                System.out.printf("�q�Ʀr�d��̤p��: ");
                int min = sc.nextInt();
                System.out.print("�q�Ʀr�d��̤j��: ");
                int max = sc.nextInt();
                System.out.printf("�q�Ʀr���ƭ���: ");
                int times = sc.nextInt();
                if (min <= 0 || max <= 0 || times <= 0 || max <= min) {
                    System.out.print("��J���~!\n" +
                            "�̤p�ȡB�̤j�ȡB���ƶ�������ơA\n" +
                            "�̤j�ȶ��j��̤p�ȡC\n\n");
                    continue;
                }
                Guess guess = new Guess(min, max, times);
                System.out.println("********** �C���}�l **********");
                int[] record = new int[times + 1];
                int actual_times = times;
                for (int i = 1; i <= times; i++) {
                    System.out.printf("�Ʀr�d��: %d��%d\n", min, max);
                    System.out.printf("�z�q���Ʀr: ");
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
                System.out.println("********** �C������ **********");
                for (int i = 1; i <= actual_times; i++) {
                    System.out.printf("�� %d �q: %d\n", i, record[i]);
                }
                System.out.println("---");
                System.out.printf("�q�Ʀr���� %d ��\n", times);
                System.out.printf("�z�`�@�q�F %d ��\n", actual_times);
                System.out.printf("���T�Ʀr: %d\n", guess.getAnswer());
                System.out.println("******* �A���@��<Y/N>? *******");
                String Yes_No = sc.next();
                if (Yes_No.equals("N")||Yes_No.equals("n"))
                    end = true;
            } catch (Exception e) {
                System.out.print("��J���~!\n" +
                        "�Ъ`�N��J��ƫ��O�O�_���~�C\n\n");
            }
        } while (!end);
    }
}

