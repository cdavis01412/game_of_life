import java.util.ArrayList;

public class GameRules {
    enum Direction {
        NORTHWEST(-1, -1),
        NORTH(0, -1),
        NORTHEAST(1, -1),
        EAST(1, 0),
        SOUTHEAST(1, 1),
        SOUTH(0, 1),
        SOUTHWEST(-1, 1),
        WEST(-1, 0),
        ;
    
        final int dx;
        final int dy;
        
        Direction(int dx, int dy) {this.dx = dx; this.dy = dy;}
    }

    private int y_rows;
    private int x_columns;
    private boolean[][] cellGrid;
    
    public GameRules(ArrayList<Cell> cells ,int rows, int columns){
        this.y_rows = rows;
        this.x_columns = columns;
        this.cellGrid = new boolean[y_rows][x_columns];
        for (Cell c : cells) {
            this.cellGrid[c.getY()][c.getX()] = c.isAlive();
        }
    }

    public void applyRules(ArrayList<Cell> cells){

        int n;
        for (Cell cell : cells) { 
            n = countNeighbors(cell);
            if((!cell.isAlive()) && n == 3) {cell.setNext(true);}
            else if(!cell.isAlive() && (n != 3)) {cell.setNext(false);}
            else if(cell.isAlive() && ((n < 2) || (n > 3))){cell.setNext(false);}
            else {cell.setNext(true);}
        }

        for (Cell cell : cells) {
            cell.updateCell();
            cellGrid[cell.getY()][cell.getX()] = cell.isAlive();
        }
    }


    private int countNeighbors(Cell c){
        int num_neighbors = 0;
        for (Direction d : Direction.values()) {    
        
            try {
                if(cellGrid[c.getY() + d.dy][c.getX() + d.dx] == true){++num_neighbors;}
            } catch (Exception e) {
                continue;
            }
        }
        return num_neighbors;
    }
}
