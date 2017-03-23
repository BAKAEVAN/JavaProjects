import java.util.*;

public class Account {

    private float balance;
    private boolean open = false;
    

    public void Open_Account() {
        try {
            Scanner input = new Scanner(System.in);
            if (open == false) {
                System.out.print("�п�J�}����B: ");
                float start_money = input.nextFloat();
                if (start_money >= 1000) {
                    System.out.printf("�}�ᦨ�\! �s�J $%.2f ��\n\n", start_money);
                    balance = start_money;
                    open = true;
                } else if (start_money < 1000) {
                    System.out.println("�}����B����!\n");
                }
            } else {
                System.out.println("�w�}��!\n");
            }
        } catch (InputMismatchException ex) {
            System.out.println("�}��o�Ϳ��~! �п�J���B!\n");
        }
    }

    public void Deposit_Account() {
        try {
            Scanner input = new Scanner(System.in);
            if (open == false) {
                System.out.println("���}��!\n");
            } else {
                System.out.print("�п�J�s�ڪ��B: ");
                float deposit = input.nextFloat();
                if (deposit < 0) {
                    System.out.println("�s�ڥ���! �п�J�D�t�ƭ�!\n");
                } else {
                    System.out.printf("���\�s�J $%.2f ��\n\n", deposit);
                    balance += deposit;
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("�s�ڵo�Ϳ��~! �п�J���B!\n");
        }
    }

    public void Withdrawals_Account() {
        try {
            Scanner input = new Scanner(System.in);
            if (open == false) {
                System.out.println("���}��!\n");
            } else {
                System.out.print("�п�J���ڪ��B: ");
                float withdrawals = input.nextFloat();
                if (withdrawals > balance) {
                    System.out.println("���ڥ���! ���ڪ��B�j��ثe�l�B!\n");
                }else if(withdrawals < 0) {
                    System.out.println("���ڥ���! �п�J�D�t�ƭ�!\n");
                } else {
                    System.out.printf("���\��X $%.2f ��\n\n", withdrawals);
                    balance -= withdrawals;
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("���ڵo�Ϳ��~! �п�J���B!\n");
        }
    }

    public void Get_Balance() {
        if (open == false) {
            System.out.println("���}��!\n");
        } else {
            System.out.printf("�ثe�l�B: $%.2f ��\n\n", balance);
        }
    }
}
