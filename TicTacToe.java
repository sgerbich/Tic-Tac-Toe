import java.util.Scanner;

public class TicTacToe {
    // Instance Variables
    private char[][] board;
    private int turns;
    static Scanner input = new Scanner(System.in);

    // Constructors
    public TicTacToe() {
        board = new char[3][3];
        turns = 0;

        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                board[r][c] = ' ';
    }

    // Accessor Methods

    public boolean isWinner(char p) {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == p && board[i][1]==board[i][0] && board[i][1]==board[i][2]) {
                return true;
            }
        }
        // check cols
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == p && board[1][i]==board[0][i] && board[1][i]==board[2][i]) {
                return true;
            }
        }
        // check diagonal
        if(board[0][0] == p && board[1][1]==board[0][0] && board[2][2]==board[1][1]){
            return true;
        }

        if(board[2][0] == p && board[1][1]==board[2][0] && board[0][2]==board[1][1]){
            return true;
        }
        return false;
    }

    

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isCat() {
        if (turns >= 9 && !isWinner('X')&& !isWinner('O')){
            return true;
        }
        return false;
    }

    public boolean isValid(int r, int c) {
        if (0 <= r && r <= 2 && 0 <= c && c <= 2)
            return true;
        else
            return false;
    }

    public int numTurns() {
        return turns;
    }

    public char playerAt(int r, int c) {
        if (isValid(r, c))
            return board[r][c];
        else
            return '@';
    }

    public void displayBoard() {
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }

    // Modifiers
    public void playMove(char p, int r, int c) {
        if (board[r][c] == ' ') {
            board[r][c] = p;
            turns++;
        } else {
            System.out.println("sorry you cant go here. try again");
        }
    }

    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
        ttt.displayBoard();
        char p = 'X';
        while (!ttt.isCat() && !ttt.isWinner(p)) {
            // System.out.println( + " Choose your location (row, column):");

            if (ttt.numTurns() % 2 != 0) {
                p = 'O';
            } else {
                p = 'X';
            }
            int row = input.nextInt();
            int col = input.nextInt();
            ttt.playMove(p, row, col);
            ttt.displayBoard();

        }

        if (ttt.isWinner(p)){
            System.out.println("Congratulations "+ p+ " you win!");
        }

        if (ttt.isCat()){
            System.out.println("Its a tie");
        }
    }
}