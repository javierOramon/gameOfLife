package javi.katas.gameoflife;

public class Board {

    private final Integer rows;
    private final Integer columns;

    public Board(Integer rows, Integer columns) {

        this.rows = rows;
        this.columns = columns;
    }

    public Integer rows() {
        return rows;
    }

    public Integer columns() {
        return columns;
    }
}
