package javi.katas.gameoflife;

public class PainterCell {
    public String paint(Cell cell) {
        String symbol = "";
        if(Cell.DIE.equals(cell)){
            symbol = "*";
        }else if(Cell.ALIVE.equals(cell)){
            symbol = "o";
        }
        return symbol;
    }
}
