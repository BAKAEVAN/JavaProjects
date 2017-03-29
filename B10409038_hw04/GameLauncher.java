/**
 * Created by B10409038 on 2017/3/29.
 */

import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {
        boolean end = false;
        boolean emptied=true;
        char turn = 'X';
        TicTacToe game = new TicTacToe();
        Scanner sc = new Scanner(System.in);
        System.out.println("********** Game Start **********");
        do {
            if (turn == 'X')
                System.out.print("Player-X,enter your move (row[1-3],column[1-3]): ");
            else
                System.out.print("Player-O,enter your move (row[1-3],column[1-3]): ");
            String input = sc.next();
            if (game.setGame_record(input, turn))
                continue;

            game.display_Tic_Tac_Toe();

            if (game.display_result()) {
                if (game.connect_successful('O'))
                    turn = 'X';
                else if (game.connect_successful('X'))
                    turn = 'O';
                else if (game.draw()) {
                    if (turn == 'X')
                        turn = 'O';
                    else
                        turn = 'X';
                }
                game.emptied_game_record();
                System.out.println("********** Game Over **********");
                System.out.print("Play again(Y/N)? ");
                String again = sc.next();
                if (again.equals("N") || again.equals("n"))
                    end=true;
                else
                    System.out.println("********* Game Start **********");
            }
            else{
                if (turn == 'X')
                    turn = 'O';
                else
                    turn = 'X';
            }
        } while (!end);
    }
}
