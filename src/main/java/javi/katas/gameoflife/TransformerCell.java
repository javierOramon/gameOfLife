package javi.katas.gameoflife;

public class TransformerCell {

    public Cell transform(Coordinate center, Board board, Integer range){
        AroundCells aroundCells = board.neightbours(center, range);
        Integer amountLives = Math.toIntExact(aroundCells.neightbours().stream().filter(cell -> Cell.ALIVE.equals(cell)).count());
        Cell result = transformCell(center, board, amountLives);
        return result;
    }

    private Cell transformCell(Coordinate center, Board board, Integer amountLives) {
        Cell cell = liveCell(amountLives, center, board);
        if(cell == null){
            cell = Cell.DIE;
        }
        return cell;
    }

    private Cell killCell(Integer amountLives, Coordinate center, Board board){
        if(amountLives >= 2 && amountLives != 4) return null;

        return Cell.DIE;
    }

    private Cell liveCell(Integer amountLives, Coordinate center, Board board){
        Cell cell = board.recoverCell(center);
        boolean shouldRevive = Cell.DIE.equals(cell) && amountLives == 3;
        boolean shouldSurvive = Cell.ALIVE.equals(cell) && (amountLives == 2 || amountLives == 3);
        if(shouldRevive || shouldSurvive){
            return Cell.ALIVE;
        }
        return null;
    }
}
