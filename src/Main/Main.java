package Main;
import GUI.GUI;
import board.Board;
public class Main {
    public static void main(String[] args) {
        Board sudokuBoard = new Board(9);
        int datos[][] = sudokuBoard.generateSudoku(9);
    }
}
