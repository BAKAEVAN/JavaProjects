import java.util.Scanner;

/**
 * Created by B10409038 on 2017/4/27.
 */
public class BookStore {
    public static void main(String[] args) {
        showMenu();/** ��� menu*/
        Scanner sc = new Scanner(System.in);
        BookOrder bookOrder = new BookOrder();
        String booknumber = new String();
        String quantity = new String();
        String continue_buy = new String();
        String buyername = new String();
        String cellphone = new String();
        do {
            System.out.print("�п�J�q�ʮ��y [1-6]: ");
            booknumber = sc.next();/** ���o�ϥΪ̿�J���q�ʮ��y*/
            if (!bookOrder.check_booknumber(booknumber))
                continue;
            System.out.print("�ƶq: ");
            quantity = sc.next();/** ���o�ϥΪ̿�J���q�ʮ��y���ƶq*/
            if (!bookOrder.check_quantity(quantity))
                continue;
            bookOrder.purchase_record(Integer.parseInt(booknumber), Integer.parseInt(quantity));
            System.out.print("�~����ʶ�?(Y/N)");
            continue_buy = sc.next();/** ���o�ϥΪ̿�J�O�_�~���ʶR*/
        } while (!continue_buy.equals("N") || continue_buy.equals("n"));
        do {
            System.out.print("�п�J�z���m�W: ");
            buyername = sc.next();/** ���o�ϥΪ̿�J�m�W*/
            if (!bookOrder.check_buyername(buyername)) {
                System.out.println("�п�J���T�m�W!");
                continue;
            }
        } while (!bookOrder.check_buyername(buyername));
        do {
            System.out.print("�п�J�s���q��: ");
            cellphone = sc.next();/** ���o�ϥΪ̿�J�s���q��*/
            if (!bookOrder.check_cellphone(cellphone)) {
                System.out.println("�q�ܮ榡���~! (�榡: XXXX-XXXXXX)");
                continue;
            }
        } while (!bookOrder.check_cellphone(cellphone));
        System.out.println();
        bookOrder.displayOrder();
    }

    public static void showMenu() {
        System.out.println("********** Welcome to Book Store **********");
        for (Book book : Book.values()) {
            System.out.printf("%s)%-8s\t%s ��\n", book.getBooknumber(), book.getBookname(), book.getPrice());
        }
        System.out.println();
    }
}
