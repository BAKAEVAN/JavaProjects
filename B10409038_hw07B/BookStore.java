import java.util.Scanner;

/**
 * Created by B10409038 on 2017/4/27.
 */
public class BookStore {
    public static void main(String[] args) {
        showMenu();/** 顯示 menu*/
        Scanner sc = new Scanner(System.in);
        BookOrder bookOrder = new BookOrder();
        String booknumber = new String();
        String quantity = new String();
        String continue_buy = new String();
        String buyername = new String();
        String cellphone = new String();
        do {
            System.out.print("請輸入訂購書籍 [1-6]: ");
            booknumber = sc.next();/** 取得使用者輸入欲訂購書籍*/
            if (!bookOrder.check_booknumber(booknumber))
                continue;
            System.out.print("數量: ");
            quantity = sc.next();/** 取得使用者輸入欲訂購書籍之數量*/
            if (!bookOrder.check_quantity(quantity))
                continue;
            bookOrder.purchase_record(Integer.parseInt(booknumber), Integer.parseInt(quantity));
            System.out.print("繼續選購嗎?(Y/N)");
            continue_buy = sc.next();/** 取得使用者輸入是否繼續購買*/
        } while (!continue_buy.equals("N") || continue_buy.equals("n"));
        do {
            System.out.print("請輸入您的姓名: ");
            buyername = sc.next();/** 取得使用者輸入姓名*/
            if (!bookOrder.check_buyername(buyername)) {
                System.out.println("請輸入正確姓名!");
                continue;
            }
        } while (!bookOrder.check_buyername(buyername));
        do {
            System.out.print("請輸入連絡電話: ");
            cellphone = sc.next();/** 取得使用者輸入連絡電話*/
            if (!bookOrder.check_cellphone(cellphone)) {
                System.out.println("電話格式有誤! (格式: XXXX-XXXXXX)");
                continue;
            }
        } while (!bookOrder.check_cellphone(cellphone));
        System.out.println();
        bookOrder.displayOrder();
    }

    public static void showMenu() {
        System.out.println("********** Welcome to Book Store **********");
        for (Book book : Book.values()) {
            System.out.printf("%s)%-8s\t%s 元\n", book.getBooknumber(), book.getBookname(), book.getPrice());
        }
        System.out.println();
    }
}
