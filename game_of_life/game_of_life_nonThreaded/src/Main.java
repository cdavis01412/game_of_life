import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        
        ArrayList<Cell> cells = new ArrayList<Cell>();

        String data = FileManip.read("initLife.txt");
        GameValues gv = new GameValues(data);
        cells = gv.getCellList();

        Board b = new Board(gv.getRows(), gv.getColumns());
        b.render(cells);
        GameRules gr = new GameRules(cells, gv.getRows(), gv.getColumns());
        
        for (int i = 0; i < gv.getGenerations(); i++) {
            TimeUnit.SECONDS.sleep(1);
            gr.applyRules(cells);
            b.render(cells);
        }
    }
}
