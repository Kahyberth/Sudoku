package board;

public class Board {

    private int coord_x = 0;
    private int coord_y = 0;

    private int quantity;

    public Board(int quantity) {
        this.quantity = quantity;
        System.out.println("Sudoku Iniciado!");
    }


    public int board(int quantity) {
        int [][]sudoku_board = new int[quantity][quantity];

        return 0;
    }

    public void fillBoard(){
        int random = (int)(Math.random()*10 + 4);
        int [] current_row = new int[quantity];
        int [] current_column = new int[quantity];
        System.out.println("Random: " + random);
        for(int i = 1; i < random; i++) {
            System.out.println((int)(Math.random()*i) + 1);
        }
    }



}
