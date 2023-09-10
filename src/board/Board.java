package board;

import GUI.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Board implements ActionListener {

    private int quantity;
    private int attempts = 3;

    private int[][] sudoku_board = new int[this.quantity][this.quantity];

    GUI sudokuGUI = new GUI();


    public Board(int quantity) {
        System.out.println("Sudoku Iniciado!!");
        this.quantity = quantity;
        this.sudoku_board = new int[quantity][quantity];
        this.generateSudoku(quantity);
        fillBoard();
        this.sudokuGUI.setVisible(true);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.sudokuGUI.field[i][j].addActionListener(this);
            }
        }
        sudokuGUI.attempts.setText(String.valueOf(attempts));
        sudokuGUI.check.addActionListener(this);
    }



    public int showBoard() {
        return this.sudoku_board.length;
    }



    public int[][] generateSudoku(int quantity) {
        generateSudokuRecursive(sudoku_board, 0, 0);
        return sudoku_board;
    }

    private boolean generateSudokuRecursive(int[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }

        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col == 8) ? 0 : col + 1;

        int[] possibleValues = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffleArray(possibleValues);

        for (int value : possibleValues) {
            if (isValidMove(board, row, col, value)) {
                board[row][col] = value;
                if (generateSudokuRecursive(board, nextRow, nextCol)) {
                    return true;
                }
                board[row][col] = 0; 
            }
        }

        return false;
    }

    private boolean isValidMove(int[][] board, int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value || board[i][col] == value) {
                return false; // Valor ya en fila o columna
            }
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == value) {
                    return false; // Valor ya en el cuadro 3x3
                }
            }
        }

        return true;
    }

    private void shuffleArray(int[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }


    private void fillBoard() {
        boolean state = false;
        for(int i = 0; i < sudokuGUI.field.length; i++) {
            for (int j = 0; j < sudokuGUI.field.length; j++) {
               if(state) {
                   sudokuGUI.field[i][j].setText(String.valueOf(this.sudoku_board[i][j]));
                   sudokuGUI.field[i][j].setForeground(Color.BLACK);
                   sudokuGUI.field[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                   state = false;
               } else if (i %2!= 0) {

                   state = true;
                }
            }
        }
    }


    public Boolean verify() {

        for(int i = 0; i < sudokuGUI.field.length; i++){
            for (int j = 0; j < sudokuGUI.field.length; j++) {
                if (sudokuGUI.field[i][j].getText() != String.valueOf(this.sudoku_board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    public void attempts() {
        attempts -= 1;
        sudokuGUI.attempts.setText(String.valueOf(attempts));
        if (attempts == 0) {
            System.out.println("You lost try again!");
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Intentalo nuevamente, Intentos: " + attempts + "\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sudokuGUI.check) {
            if (this.verify()) {
                System.out.println("Congratulations you win!");
            }
            else {
                attempts();
            }
        }
    }
}

