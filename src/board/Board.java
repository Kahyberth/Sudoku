package board;

import GUI.GUI;

import java.util.Random;

public class Board {

    private int quantity;
    private int[][] sudoku_board = new int[this.quantity][this.quantity];

    GUI sudokuGUI = new GUI();


    public Board(int quantity) {
        this.quantity = quantity;
        this.sudoku_board = new int[quantity][quantity];
        this.generateSudoku(quantity);
        fillBoard();
        this.sudokuGUI.setVisible(true);
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
        Boolean state = false;
        for(int i = 0; i < sudokuGUI.button.length; i++) {
            for (int j = 0; j < sudokuGUI.button.length; j++) {
               if(state) {
                   sudokuGUI.button[i][j].setText(String.valueOf(this.sudoku_board[i][j]));
                   state = false;
               } else if (i %2!= 0) {
                   state = true;
                }
            }
        }
    }



}

