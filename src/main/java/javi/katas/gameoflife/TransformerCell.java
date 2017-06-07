package javi.katas.gameoflife;

public class TransformerCell {

    public void transform(Coordinate center, Board board, Integer range){
        AroundCells aroundCells = board.neightbours(center, range);
        Integer amountLives = Math.toIntExact(aroundCells.neightbours().stream().filter(cell -> Cell.ALIVE.equals(cell)).count());
        killCell(amountLives, center, board);
        liveCell(amountLives, center, board);
    }

    private void killCell(Integer amountLives, Coordinate center, Board board){
        if(amountLives >= 2 && amountLives != 4) return;

        board.changeCell(center, Cell.DIE);
    }

    private void liveCell(Integer amountLives, Coordinate center, Board board){
        Cell cell = board.recoverCell(center);
        boolean shouldRevive = Cell.DIE.equals(cell) && amountLives == 3;
        boolean shouldSurvive = Cell.ALIVE.equals(cell) && (amountLives == 2 || amountLives == 3);
        if(shouldRevive || shouldSurvive){
            board.changeCell(center, Cell.ALIVE);
        }

    }
}
