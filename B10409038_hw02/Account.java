import java.util.*;

public class Account {

    private float balance;
    private boolean open = false;
    

    public void Open_Account() {
        try {
            Scanner input = new Scanner(System.in);
            if (open == false) {
                System.out.print("請輸入開戶金額: ");
                float start_money = input.nextFloat();
                if (start_money >= 1000) {
                    System.out.printf("開戶成功! 存入 $%.2f 元\n\n", start_money);
                    balance = start_money;
                    open = true;
                } else if (start_money < 1000) {
                    System.out.println("開戶金額不足!\n");
                }
            } else {
                System.out.println("已開戶!\n");
            }
        } catch (InputMismatchException ex) {
            System.out.println("開戶發生錯誤! 請輸入金額!\n");
        }
    }

    public void Deposit_Account() {
        try {
            Scanner input = new Scanner(System.in);
            if (open == false) {
                System.out.println("未開戶!\n");
            } else {
                System.out.print("請輸入存款金額: ");
                float deposit = input.nextFloat();
                if (deposit < 0) {
                    System.out.println("存款失敗! 請輸入非負數值!\n");
                } else {
                    System.out.printf("成功存入 $%.2f 元\n\n", deposit);
                    balance += deposit;
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("存款發生錯誤! 請輸入金額!\n");
        }
    }

    public void Withdrawals_Account() {
        try {
            Scanner input = new Scanner(System.in);
            if (open == false) {
                System.out.println("未開戶!\n");
            } else {
                System.out.print("請輸入提款金額: ");
                float withdrawals = input.nextFloat();
                if (withdrawals > balance) {
                    System.out.println("提款失敗! 提款金額大於目前餘額!\n");
                }else if(withdrawals < 0) {
                    System.out.println("提款失敗! 請輸入非負數值!\n");
                } else {
                    System.out.printf("成功領出 $%.2f 元\n\n", withdrawals);
                    balance -= withdrawals;
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("提款發生錯誤! 請輸入金額!\n");
        }
    }

    public void Get_Balance() {
        if (open == false) {
            System.out.println("未開戶!\n");
        } else {
            System.out.printf("目前餘額: $%.2f 元\n\n", balance);
        }
    }
}
