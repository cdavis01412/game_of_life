public class CellThread extends Thread {

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

    private Cell cell; 
    private boolean[][] cellGrid;

    public CellThread(Cell c, boolean[][] grid){
        this.cell = c;
        this.cellGrid = grid; 
    }

    // @Override
    public void run() {

            int n;
            n = countNeighbors(cell);
            if((!cell.isAlive()) && n == 3) {cell.setNext(true);}
            else if(!cell.isAlive() && (n != 3)) {cell.setNext(false);}
            else if(cell.isAlive() && ((n < 2) || (n > 3))){cell.setNext(false);}
            else {cell.setNext(true);}
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
