import java.util.*;

public class AccountTest {

    public static void main(String[] args) {
        boolean end = true;
        Account account = new Account();
        do {
            
            try {
                Scanner select = new Scanner(System.in);
                
                System.out.print("***Main Menu***\n"
                        + "1> 開戶\n"
                        + "2> 存款\n"
                        + "3> 提款\n"
                        + "4> 目前餘額\n"
                        + "0> Exit\n\n"
                        + "Please enter a number in [1,2,3,4,0]: ");
                System.out.print("請輸入: ");
                int number = select.nextInt();
                switch (number) {
                    case 1:
                        account.Open_Account();
                        break;
                    case 2:
                        account.Deposit_Account();
                        break;
                    case 3:
                        account.Withdrawals_Account();
                        break;
                    case 4:
                        account.Get_Balance();
                        break;
                    case 0:
                        System.out.println("即將離開程式.\n");
                        end = false;
                        break;
                    default:
                        System.out.println("選項輸入錯誤!\n");
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("選項輸入錯誤!\n");
            }
        } while (end);
    }
}
