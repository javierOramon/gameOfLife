package javi.katas.gameoflife;

public class TransformerCell {

    public void transform(Coordinate center, Board board, Integer range){
        AroundCells aroundCells = board.neightbours(center, range);
        Integer amountLives = Math.toIntExact(aroundCells.neightbours().stream().filter(cell -> Cell.ALIVE.equals(cell)).count());
        killCell(amountLives, center, board);
        reviveCell(amountLives, center, board);
    }

    private void killCell(Integer amountLives, Coordinate center, Board board){
        if(amountLives >= 2 && amountLives != 4) return;

        board.changeCell(center, Cell.DIE);
    }

    private void reviveCell(Integer amountLives, Coordinate center, Board board){
        if(amountLives != 3) return;

        board.changeCell(center, Cell.ALIVE);
    }
}
