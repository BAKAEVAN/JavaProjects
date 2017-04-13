/**
 * Created by B10409038 on 2017/4/12.
 */

import java.util.Scanner;

public class IDChecker {
    public static void main(String[] args) {
        int select = 0;
        do {
            try {
                ID id = new ID();
                Scanner sc = new Scanner(System.in);
                System.out.print("********************\n" +
                        "1. ���Ҩ����Ҧr��\n" +
                        "2. ���ͨ����Ҧr��\n" +
                        "0. ���}\n" +
                        "********************\n" +
                        "�п��: ");
                select = sc.nextInt();
                System.out.println("");
                switch (select) {
                    case 1:
                        System.out.print("�п�J�����Ҧr��: ");
                        String input = sc.next();
                        if (id.format_confirm(input))
                            continue;
                        id.check();
                        break;
                    case 2:
                        System.out.print("�п�J����: ");
                        String area = sc.next();
                        System.out.print("�п�J�ʧO: ");
                        String gender = sc.next();
                        if (id.area_to_alphabet(area) || id.gender_to_code(gender)) {
                            if (id.area_to_alphabet(area))
                                System.out.println("�������~");
                            if (id.gender_to_code(gender))
                                System.out.println("�ʧO���~");
                            System.out.println("");
                            continue;
                        }
                        id.generate();
                        id.check();
                        break;
                    case 0:
                        System.out.print("�h�X���{��\n");
                        break;
                    default:
                        System.out.println("��J���~");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\n��J���~");
            }
        } while (select != 0);
    }
}
