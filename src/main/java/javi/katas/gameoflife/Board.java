package javi.katas.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<List<Cell>> board;

    public Board(Integer rows, Integer columns) {
        board = new ArrayList<List<Cell>>();
        for(int currentRow = 0; currentRow < rows; currentRow++){
            List<Cell> row = new ArrayList<Cell>();
            for(int currentColumn = 0; currentColumn < columns; currentColumn++){
                row.add(Cell.DIE);
            }
            board.add(row);
        }
    }

    public Integer rows() {
        return board.size();
    }

    public Integer columns() {
        return board.get(0).size();
    }

    public Cell recoverCell(Coordinate any) {
        return board.get(any.x).get(any.y);
    }

    public void changeCell(Coordinate any, Cell cell) {
        board.get(any.x).set(any.y, cell);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board1 = (Board) o;

        return board != null ? board.equals(board1.board) : board1.board == null;
    }

    @Override
    public int hashCode() {
        return board != null ? board.hashCode() : 0;
    }
}
