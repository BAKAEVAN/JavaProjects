import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by B10409038 on 2017/4/27.
 */
public class BookOrder {
    /**
     * buyername記錄買家姓名
     * cellphone記錄買家電話
     * quantity紀錄各本書的購買數量
     * sum記錄各本書的金額小計
     */
    private String buyername;
    private String cellphone;
    private int[] quantity = new int[7];
    private float[] sum = new float[7];

    /** 檢查書籍代碼是否正確*/
    public boolean check_booknumber(String input) {
        if (!input.matches("[1-6]{1}")) {
            System.out.println("請輸入正確書籍代碼!");
            return false;
        }
        return true;
    }

    /** 檢查數量格式是否正確*/
    public boolean check_quantity(String input) {
        if (!input.matches("\\d+")) {
            System.out.println("請輸入數量!");
            return false;
        }
        return true;
    }

    /** 紀錄每次的購買數量*/
    public void purchase_record(int number, int quantity) {
        this.quantity[number] += quantity;
    }

    /** 檢查買家姓名格式是否正確*/
    public boolean check_buyername(String input) {
        if (input.matches("\\d+") || !input.matches("\\w+")) {
            return false;
        }
        buyername = input;
        return true;
    }

    /** 檢查買家的連絡電話格式是否正確*/
    public boolean check_cellphone(String input) {
        if (!input.matches("[0-9]{4}-[0-9]{6}")) {
            return false;
        }
        cellphone = input;
        return true;
    }

    /** 製作流水籤號*/
    public long make_timestamp() {
        Date dateTime = new Date();
        return (long) dateTime.getTime() / 1000;
    }

    /** 取得訂單成立時間*/
    public String showCurrentTime() {
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date current = new Date();
        return sdFormat.format(current);
    }

    /** 顯示訂單報表*/
    public void displayOrder() {
        float sum = 0;
        String aligned;
        System.out.println("********** 訂購明細 **********");
        System.out.printf("訂單編號: %d\t買家姓名: %s\t 連絡電話: %s\n", make_timestamp(), buyername, cellphone);
        System.out.println("--------------------------------------------------");
        System.out.println("書籍名稱\t單價\t數量\t小計");
        for (int i = 1; i <= 6; i++) {
            if (quantity[i] != 0) {
                for (Book book : Book.values()) {
                    if (i == Integer.parseInt(book.getBooknumber())) {
                        if (book.getBookname().length() > 3)
                            aligned = "\t";
                        else
                            aligned = "\t\t";
                        this.sum[i] += Float.parseFloat(book.getPrice()) * quantity[i];
                        System.out.printf("%s%s%s\t%d\t%.2f\n",
                                book.getBookname(), aligned, book.getPrice(), quantity[i], this.sum[i]);
                    }
                }
            }
            sum += this.sum[i];
        }
        System.out.println("--------------------------------------------------");
        System.out.printf("應付金額:\t\t\t%.2f\n", sum);
        System.out.printf("訂單成立時間: %s\n", showCurrentTime());
    }
}
