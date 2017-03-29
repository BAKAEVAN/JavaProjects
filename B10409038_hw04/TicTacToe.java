/**
 * Created by B10409038 on 2017/3/29.
 */
public class TicTacToe {

    private char[][] game_record = new char[4][4];

    public boolean setGame_record(String input, char turn) {
        boolean error = false;
        if (!input.matches("[1-3]{1},[1-3]{1}")) {
            System.out.println("The value you entered is invalid! Please try again .");
            error = true;
        } else {
            int row = input.charAt(0) - 48;
            int column = input.charAt(2) - 48;
            if (game_record[row][column] != '\u0000') {
                System.out.println("The field you entered has been scored! Please try again .");
                error = true;
            } else if (turn == 'X')
                game_record[row][column] = 'X';
            else
                game_record[row][column] = 'O';
        }
        return error;
    }

    public void display_Tic_Tac_Toe() {
        for (int row = 1; row <= 3; row++) {
            for (int column = 1; column <= 3; column++) {
                if (game_record[row][column] == '\u0000')
                    System.out.print("   ");
                else
                    System.out.printf(" %c ", game_record[row][column]);
                if (column == 1 || column == 2)
                    System.out.print("|");
                else if (column == 3 && row != 3)
                    System.out.printf("\n-----------\n");
                else
                    System.out.println("");
            }
        }
    }

    public boolean connect_successful(char who) {
        boolean win = false;
        for (int row = 1; row <= 3; row++) {
            if (game_record[row][1] == game_record[row][2] && game_record[row][2] == game_record[row][3] && game_record[row][1] == who)
                win = true;
        }
        for (int column = 1; column <= 3; column++) {
            if (game_record[1][column] == game_record[2][column] && game_record[2][column] == game_record[3][column] && game_record[1][column] == who)
                win = true;
        }
        if (game_record[1][1] == game_record[2][2] && game_record[2][2] == game_record[3][3] && game_record[1][1] == who
                || game_record[1][3] == game_record[2][2] && game_record[2][2] == game_record[3][1] && game_record[1][3] == who)
            win = true;
        return win;
    }

    public boolean draw() {
        boolean draw = false;
        int lastnull = 0;
        for (int row = 1; row <= 3; row++) {
            for (int column = 1; column <= 3; column++) {
                if (game_record[row][column] == '\u0000')
                    lastnull++;
            }
        }
        if (lastnull == 0)
            draw = true;
        return draw;
    }

    public boolean display_result() {
        boolean gameover = false;
        if (connect_successful('O')) {
            System.out.println("\nPlayer-O is the winner!");
            gameover = true;
        } else if (connect_successful('X')) {
            System.out.println("\nPlayer-X is the winner!");
            gameover = true;
        } else if (draw()) {
            System.out.println("\nEnd in a draw!");
            gameover = true;
        }
        return gameover;
    }

    public void emptied_game_record() {
        for (int row = 1; row <= 3; row++) {
            for (int column = 1; column <= 3; column++) {
                game_record[row][column] = '\u0000';
            }
        }
    }
}


