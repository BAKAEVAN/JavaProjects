/**
 * Created by B10409038 on 2017/4/27.
 */
public enum Book {
    Accounting("1", "會計學", "360.00"), Statistics("2", "統計學", "245.00"), Program_language("3", "程式語言", "600.00"),
    Economics("4", "經濟學", "445.00"), History("5", "本國史", "180.00"), English("6", "英文", "350.00");
    private final String booknumber;
    private final String bookname;
    private final String price;

    private Book(String number, String name, String value) {
        booknumber = number;
        bookname = name;
        price = value;
    }

    public String getBooknumber() {
        return booknumber;
    }

    public String getBookname() {
        return bookname;
    }

    public String getPrice() {
        return price;
    }
}
