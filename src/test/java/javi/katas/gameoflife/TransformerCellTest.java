package javi.katas.gameoflife;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransformerCellTest {

    private Board board;
    private TransformerCell transformerCell;

    @Before
    public void setUp(){
        board = new Board(5,5);
        transformerCell = new TransformerCell();
    }

    @Test
    public void cellWithoutNeighboursDie(){
        //Arrange
        final Cell expected = Cell.DIE;
        final Coordinate center = new Coordinate(0, 0);
        board.changeCell(center, Cell.ALIVE);
        //Act
        transformerCell.transform(center, board, 1);
        //Assert
        Cell cellresult = board.recoverCell(center);
        assertEquals("The cell result is alive", expected, cellresult);
    }

    @Test
    public void cellWithOneNeighbourDie(){
        //Arrange
        final Coordinate center = new Coordinate(0, 0);
        board.changeCell(center, Cell.ALIVE);
        board.changeCell(new Coordinate(0,1), Cell.ALIVE);
        //Act
        transformerCell.transform(center, board, 1);
        //Assert
        Cell cellresult = board.recoverCell(center);
        assertEquals("The cell is alive", Cell.DIE, cellresult);
    }

    @Test
    public void cellWithFourNeighboursDie(){
        //Arrange
        final Coordinate center = new Coordinate(2, 2);
        board.changeCell(center, Cell.ALIVE);
        board.changeCell(new Coordinate(1,1), Cell.ALIVE);
        board.changeCell(new Coordinate(1,2), Cell.ALIVE);
        board.changeCell(new Coordinate(1,3), Cell.ALIVE);
        board.changeCell(new Coordinate(2,1), Cell.ALIVE);
        //Act
        transformerCell.transform(center, board,1);
        //Assert
        Cell cellResult = board.recoverCell(center);
        assertEquals("The cell is alive", Cell.DIE, cellResult);
    }

    @Test
    public void cellAliveWithTwoNeightboursSurvive(){
        //Arrange
        final Coordinate center = new Coordinate(2, 2);
        board.changeCell(center, Cell.ALIVE);
        board.changeCell(new Coordinate(1,1), Cell.ALIVE);
        board.changeCell(new Coordinate(1,2), Cell.ALIVE);
        //Act
        transformerCell.transform(center, board, 1);
        //Assert
        Cell cellResult = board.recoverCell(center);
        assertEquals("The cell is death", Cell.ALIVE, cellResult);
    }

    @Test
    public void cellAliveWithThreeNeightboursSurvive(){
        //Arrange
        final Coordinate center = new Coordinate(2, 2);
        board.changeCell(center, Cell.ALIVE);
        board.changeCell(new Coordinate(1,1), Cell.ALIVE);
        board.changeCell(new Coordinate(1,2), Cell.ALIVE);
        board.changeCell(new Coordinate(1,3), Cell.ALIVE);
        //Act
        transformerCell.transform(center, board, 1);
        //Assert
        Cell cellResult = board.recoverCell(center);
        assertEquals("The cell is death", Cell.ALIVE, cellResult);
    }

    @Test
    public void cellDeathWithThreeNeightboursRevive(){
        //Arrange
        final Coordinate center = new Coordinate(2, 2);
        board.changeCell(new Coordinate(1,1), Cell.ALIVE);
        board.changeCell(new Coordinate(1,2), Cell.ALIVE);
        board.changeCell(new Coordinate(1,3), Cell.ALIVE);
        //Act
        transformerCell.transform(center, board, 1);
        //Assert
        Cell cellResult = board.recoverCell(center);
        assertEquals("The cell is death", Cell.ALIVE, cellResult);
    }

    @Test
    public void cellDeathWithTwoNeightboursDie(){
        //Arrange
        final Coordinate center = new Coordinate(2, 2);
        board.changeCell(new Coordinate(2,1), Cell.ALIVE);
        board.changeCell(new Coordinate(2,3), Cell.ALIVE);
        //Act
        transformerCell.transform(center, board, 1);
        //Assert
        Cell cellResult = board.recoverCell(center);
        assertEquals("The cell is alive", Cell.DIE, cellResult);
    }
}
