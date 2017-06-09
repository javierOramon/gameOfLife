package javi.katas.gameoflife;

public class GameOfLife {

    private final Board board;
    private final TransformerCell transformer;

    public GameOfLife(Board board, TransformerCell transformer) {
        this.board = board;
        this.transformer = transformer;
    }

    public GameOfLife execute() {
        Board newBoard = new Board(board.rows(), board.columns());
        for (int row = 0; row < board.rows(); row++){
            for (int column = 0; column < board.columns(); column++){
                Coordinate coordinate = new Coordinate(row, column);
                Cell cellGenerated = this.transformer.transform(coordinate, board, 1);
                newBoard.changeCell(coordinate, cellGenerated);
            }
        }

        return new GameOfLife(newBoard, transformer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameOfLife that = (GameOfLife) o;

        return board.equals(that.board);
    }

    @Override
    public int hashCode() {
        return board.hashCode();
    }
}
