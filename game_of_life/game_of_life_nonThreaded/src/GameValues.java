import java.util.ArrayList;

public class GameValues {

private ArrayList<Cell> cells = new ArrayList<Cell>();
private int num_generations = -1; 
private int y_rows;
private int x_columns; 
final private boolean alive = true;
final private boolean dead = false;

    public GameValues(String s) throws Exception{
        char[] c = s.toCharArray();

        for (char d : c) {
            if(d == '\n'){++y_rows; x_columns = 0;}
            else {
                if(d == '.'){cells.add(new Cell(dead, x_columns, y_rows));}
                else if (Character.isDigit(d)) {num_generations = Integer.parseInt(String.valueOf(d)); break;}
                else {cells.add(new Cell(alive, x_columns, y_rows));}
                ++x_columns;
            }
        }

        // Ensures columns are the same length for each row of input
        String[] lines = s.split("\n");
        for (String line : lines) {
            try {
                num_generations = Integer.parseInt(line);
            } catch (Exception e) {
                continue;
            }
        }


        for(int i = 0; i < y_rows; ++i){
            if(lines[0].length() != lines[i].length()) {
                throw new Exception("Column lengths of input file do not match");
            }
        }
        x_columns = lines[0].length();
        
    }

    public int getGenerations() {return (int)num_generations;}
    public int getRows(){return y_rows;}
    public int getColumns(){return x_columns;}
    public ArrayList<Cell> getCellList() {return cells;}
}
