package Main;
import board.Board;
public class Main {
    public static void main(String[] args) {
        Board sudokuBoard = new Board(9);
        sudokuBoard.fillBoard();
    }
}
