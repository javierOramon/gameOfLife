package javi.katas.gameoflife;

public class GameOfLife {

    private final Board board;
    private final TransformerCell transformer;

    public GameOfLife(Board board, TransformerCell transformer) {
        this.board = board;
        this.transformer = transformer;
    }

    public void execute() {
        for (int row = 0; row < board.rows(); row++){
            for (int column = 0; column < board.columns(); column++){
                Coordinate coordinate = new Coordinate(row, column);
                this.transformer.transform(coordinate, board, 1);
            }
        }
    }
}
