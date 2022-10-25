import java.util.ArrayList;

public class Board {

    private int x_columns;
    private int y_rows; 
    private int generations = 0;
    private String alive = "# ";
    private String dead = ". ";

    public Board(int rows, int columns){
        this.y_rows = rows;
        this.x_columns = columns;
    }

    // rednders intial board from ArrayList
    public void render(ArrayList<Cell> cells){
        boolean[][] board = new boolean[y_rows][x_columns];
        for (Cell c : cells) {
            board[c.getY()][c.getX()] = c.isAlive();
        }

        for (int i = 0; i < y_rows; i++) {
            for (int j = 0; j < x_columns; j++) {
                if (board[i][j] == false) {System.out.print(dead);}
                else {System.out.print(alive);}
            }
            System.out.println("");
        }
        System.out.println(generations + "\n");
        ++generations;
        
    }

    // rednders board from boolean cellGrid
    public void render(boolean[][] board){

        for (int i = 0; i < y_rows; i++) {
            for (int j = 0; j < x_columns; j++) {
                if (board[i][j] == false) {System.out.print(dead);}
                else {System.out.print(alive);}
            }
            System.out.println("");
        }
        System.out.println(generations + "\n");
        ++generations;
        
    }
}
