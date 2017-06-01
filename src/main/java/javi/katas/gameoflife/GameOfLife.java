package javi.katas.gameoflife;

public class GameOfLife {
    private Board board;

    public GameOfLife(Board board) {
        this.board = board;
    }

    public void execute(int range) {
        for (int row = 0; row < board.rows(); row++){
            for(int column = 0; column < board.columns(); column++){
                final Coordinate centerCell = new Coordinate(row, column);
                AroundCells aroundCells = board.neightbours(centerCell, range);
                long amountLives = aroundCells.neightbours().stream().filter(cell -> Cell.ALIVE.equals(cell)).count();
                if(amountLives < 2){
                    board.changeCell(centerCell, Cell.DIE);
                }
            }
        }
    }

    public Board recoverBoard() {
        return board;
    }
}
