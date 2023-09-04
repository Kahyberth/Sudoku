package board;

import java.sql.Array;

public class Board {

    private int quantity;
    private final int [][]sudoku_board = new int[quantity][quantity];
    public Board(int quantity) {
        this.quantity = quantity;
        System.out.println("Sudoku Iniciado!");
    }

    public int[][] showBoard () {
        for(int i = 0; i < sudoku_board.length; i++) {
            for (int j = 0; j < sudoku_board.length; j++) {
                System.out.println(sudoku_board[i][j] + "\n");
            }
        }
        return this.sudoku_board;
    }
    //TODO: The conditionals of the loops need to be corrected and retested.
    public int fillBoard() {
        int random_value = (int)(Math.random()*8 + 1);
        int index_column = 0, index_row = 0;
        int [] current_row = new int [quantity];
        for (int i = 0; i <= this.sudoku_board.length; i++) {
           if ( current_row.length > 0 ) {
               this.sudoku_board[index_row][index_column] = current_row[index_column];
           }
            for (int j = 0; j < this.sudoku_board.length; j++) {
                random_value = (int)(Math.random()*8 + 1); //Generates random numbers
                if ( current_row[j] != random_value ) {
                    current_row[index_column] = random_value;
                    index_column ++;
                    break;
                }
            }
            //Reinicia el valor del current_row, index_column y incrementa la fila
            if ( current_row.length > 8 ) {
                index_row++;
                index_column = 0;
                current_row = new int [quantity];
            }
        }

        return this.sudoku_board.length;
    }



}
