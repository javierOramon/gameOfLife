package javi.katas.gameoflife;

public class TransformerCell {

    public void transform(Coordinate center, Board board, Integer range){
        AroundCells aroundCells = board.neightbours(center, range);
        long amountLives = aroundCells.neightbours().stream().filter(cell -> Cell.ALIVE.equals(cell)).count();
        if(amountLives < 2 || amountLives == 4){
            board.changeCell(center, Cell.DIE);
        }else if(amountLives == 3){
            board.changeCell(center, Cell.ALIVE);
        }
    }
}
