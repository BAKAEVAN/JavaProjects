/**
 * Created by B10409038 on 2017/3/30.
 */

import java.util.Scanner;

public class Checker {
    public static void main(String[] args) {
        System.out.print("Enter the sudoku :\n");
        Scanner sc = new Scanner(System.in);
        Sudoku sudoku = new Sudoku();
        String input;
        for (int row = 1; row <= 9; row++) {
            input = sc.nextLine();
            sudoku.access_input(row, input);
        }
        System.out.println("");
        sudoku.displaySudoku();
        if (sudoku.check_row() || sudoku.check_column() || sudoku.check_block())
            System.out.println("false");
        else
            System.out.println("true");
    }
}
