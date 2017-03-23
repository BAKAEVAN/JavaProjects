import java.util.*;

public class AccountTest {

    public static void main(String[] args) {
        boolean end = true;
        Account account = new Account();
        do {
            
            try {
                Scanner select = new Scanner(System.in);
                
                System.out.print("***Main Menu***\n"
                        + "1> �}��\n"
                        + "2> �s��\n"
                        + "3> ����\n"
                        + "4> �ثe�l�B\n"
                        + "0> Exit\n\n"
                        + "Please enter a number in [1,2,3,4,0]: ");
                System.out.print("�п�J: ");
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
                        System.out.println("�Y�N���}�{��.\n");
                        end = false;
                        break;
                    default:
                        System.out.println("�ﶵ��J���~!\n");
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("�ﶵ��J���~!\n");
            }
        } while (end);
    }
}
