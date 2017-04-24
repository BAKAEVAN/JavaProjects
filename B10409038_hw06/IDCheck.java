import java.io.*;

/**
 * Created by B10409038 on 2017/4/24.
 */

public class IDCheck {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("input.txt");
            BufferedReader input = new BufferedReader(fr);
            FileWriter fw_correct = new FileWriter("correct.txt");
            BufferedWriter output_correct = new BufferedWriter(fw_correct);
            FileWriter fw_error = new FileWriter("error.txt");
            BufferedWriter output_error = new BufferedWriter(fw_error);
            String line;
            int count = 0;
            while ((line = input.readLine()) != null) {
                ID id = new ID();
                count++;
                if (id.check(line)) {
                    output_correct.write(id.correct_message());
                    output_correct.newLine();
                } else {
                    output_error.write(id.error_message());
                    output_error.newLine();
                }
            }
            input.close();
            fr.close();
            output_correct.close();
            fw_correct.close();
            output_error.close();
            fw_error.close();
            System.out.printf("\nIDCheck(File)\n程式執行完成 ...\n總共處理了%d筆資料\n", count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
