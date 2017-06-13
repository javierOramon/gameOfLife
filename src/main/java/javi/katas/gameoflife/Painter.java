package javi.katas.gameoflife;

public class Painter {
    private final PainterCell painterCell;

    public Painter(PainterCell painterCell) {
        this.painterCell = painterCell;
    }

    public String paint(Board board) {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < board.rows(); row++){
            for (int column = 0; column < board.columns(); column++){
                Cell cell = board.recoverCell(new Coordinate(row, column));
                result.append(painterCell.paint(cell));
            }
            result.append("\n");
        }
        return result.toString();
    }
}
