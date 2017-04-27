import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by B10409038 on 2017/4/27.
 */
public class BookOrder {
    /**
     * buyername�O���R�a�m�W
     * cellphone�O���R�a�q��
     * quantity�����U���Ѫ��ʶR�ƶq
     * sum�O���U���Ѫ����B�p�p
     */
    private String buyername;
    private String cellphone;
    private int[] quantity = new int[7];
    private float[] sum = new float[7];

    /** �ˬd���y�N�X�O�_���T*/
    public boolean check_booknumber(String input) {
        if (!input.matches("[1-6]{1}")) {
            System.out.println("�п�J���T���y�N�X!");
            return false;
        }
        return true;
    }

    /** �ˬd�ƶq�榡�O�_���T*/
    public boolean check_quantity(String input) {
        if (!input.matches("\\d+")) {
            System.out.println("�п�J�ƶq!");
            return false;
        }
        return true;
    }

    /** �����C�����ʶR�ƶq*/
    public void purchase_record(int number, int quantity) {
        this.quantity[number] += quantity;
    }

    /** �ˬd�R�a�m�W�榡�O�_���T*/
    public boolean check_buyername(String input) {
        if (input.matches("\\d+") || !input.matches("\\w+")) {
            return false;
        }
        buyername = input;
        return true;
    }

    /** �ˬd�R�a���s���q�ܮ榡�O�_���T*/
    public boolean check_cellphone(String input) {
        if (!input.matches("[0-9]{4}-[0-9]{6}")) {
            return false;
        }
        cellphone = input;
        return true;
    }

    /** �s�@�y���Ҹ�*/
    public long make_timestamp() {
        Date dateTime = new Date();
        return (long) dateTime.getTime() / 1000;
    }

    /** ���o�q�榨�߮ɶ�*/
    public String showCurrentTime() {
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date current = new Date();
        return sdFormat.format(current);
    }

    /** ��ܭq�����*/
    public void displayOrder() {
        float sum = 0;
        String aligned;
        System.out.println("********** �q�ʩ��� **********");
        System.out.printf("�q��s��: %d\t�R�a�m�W: %s\t �s���q��: %s\n", make_timestamp(), buyername, cellphone);
        System.out.println("--------------------------------------------------");
        System.out.println("���y�W��\t���\t�ƶq\t�p�p");
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
        System.out.printf("���I���B:\t\t\t%.2f\n", sum);
        System.out.printf("�q�榨�߮ɶ�: %s\n", showCurrentTime());
    }
}
