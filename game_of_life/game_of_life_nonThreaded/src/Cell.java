public class Cell {
    private boolean alive_current;
    private boolean alive_next;
    private int y_position;
    private int x_position;


    public Cell(boolean a, int x, int y){
        this.alive_current = a;
        this.x_position = x;
        this.y_position = y;
        this.alive_next = false;
    }

    public void updateCell(){
        this.alive_current = this.alive_next;
        this.alive_next = false;
    }

    public void setNext(boolean x){alive_next = x;}
    public int getX() {return x_position;}
    public int getY() {return y_position;}
    public boolean isAlive() {return alive_current;}
   
}
