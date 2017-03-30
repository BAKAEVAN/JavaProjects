/**
 * Created by B10409038 on 2017/3/30.
 */
public class Sudoku {
    private int[][] sudoku = new int[10][10];

    public void access_input(int row, String input) {
        int column = 1;
        for (int length = 0; length < input.length(); length++) {
            if (length % 2 == 0) {
                sudoku[row][column] = input.charAt(length) - 48;
                column++;
            }
        }
    }

    public void displaySudoku() {
        for (int row = 1; row <= 9; row++) {
            for (int column = 1; column <= 9; column++) {
                System.out.printf("%d", sudoku[row][column]);
                if (column != 9)
                    System.out.print(" ");
                else
                    System.out.println("");
            }
        }
        System.out.println("");
    }

    public boolean check_row() {
        boolean worng = false;
        for (int row = 1; row <= 9; row++) {
            int[] check = new int[10];
            for (int column = 1; column <= 9; column++) {
                check[column] = sudoku[row][column];
                for (int e = 1; e < column; e++) {
                    if (check[e] == check[column])
                        worng = true;
                }
            }
        }
        return worng;
    }

    public boolean check_column() {
        boolean worng = false;
        for (int column = 1; column <= 9; column++) {
            int[] check = new int[10];
            for (int row = 1; row <= 9; row++) {
                check[row] = sudoku[row][column];
                for (int e = 1; e < row; e++) {
                    if (check[e] == check[row])
                        worng = true;
                }
            }
        }
        return worng;
    }

    public boolean check_block() {
        boolean worng = false;
        int start_row, start_column;
        for (int block = 1; block <= 9; block++) {
            int[] check = new int[10];
            int count = 1;
            if (block >= 1 && block <= 3)
                start_row = 1;
            else if (block >= 4 && block <= 6)
                start_row = 4;
            else
                start_row = 7;
            if (block % 3 == 1)
                start_column = 1;
            else if (block % 3 == 2)
                start_column = 4;
            else
                start_column = 7;
            for (int x = start_row; x < start_row + 3; x++) {
                for (int y = start_column; y < start_column + 3; y++) {
                    check[count] = sudoku[x][y];
                    for (int e = 1; e < count; e++) {
                        if (check[e] == check[count])
                            worng = true;
                    }
                    count++;
                }
            }
        }
        return worng;
    }
}
