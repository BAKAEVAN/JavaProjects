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
                        "1. 驗證身份證字號\n" +
                        "2. 產生身分證字號\n" +
                        "0. 離開\n" +
                        "********************\n" +
                        "請選擇: ");
                select = sc.nextInt();
                System.out.println("");
                switch (select) {
                    case 1:
                        System.out.print("請輸入身份證字號: ");
                        String input = sc.next();
                        if (id.format_confirm(input))
                            continue;
                        id.check();
                        break;
                    case 2:
                        System.out.print("請輸入縣市: ");
                        String area = sc.next();
                        System.out.print("請輸入性別: ");
                        String gender = sc.next();
                        if (id.area_to_alphabet(area) || id.gender_to_code(gender)) {
                            if (id.area_to_alphabet(area))
                                System.out.println("縣市錯誤");
                            if (id.gender_to_code(gender))
                                System.out.println("性別錯誤");
                            System.out.println("");
                            continue;
                        }
                        id.generate();
                        id.check();
                        break;
                    case 0:
                        System.out.print("退出此程式\n");
                        break;
                    default:
                        System.out.println("輸入錯誤");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\n輸入錯誤");
            }
        } while (select != 0);
    }
}
