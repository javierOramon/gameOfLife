package javi.katas.gameoflife;

public class TransformerCell {

    public TransformerCell() {

    }

    public void transform(Coordinate center, Board board, Integer range){

    }

//    public void execute(int range) {
//        for (int row = 0; row < board.rows(); row++){
//            for(int column = 0; column < board.columns(); column++){
//                final Coordinate centerCell = new Coordinate(row, column);
//                AroundCells aroundCells = board.neightbours(centerCell, range);
//                long amountLives = aroundCells.neightbours().stream().filter(cell -> Cell.ALIVE.equals(cell)).count();
//                if(amountLives < 2 || amountLives == 4){
//                    board.changeCell(centerCell, Cell.DIE);
//                }
//            }
//        }
//    }
}
