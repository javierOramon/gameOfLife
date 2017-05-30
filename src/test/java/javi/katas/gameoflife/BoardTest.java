package javi.katas.gameoflife;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardTest {

    @Before
    public void setUp(){

    }

    @Test
    public void checkHeighOfBoard(){
        //Arrange
        final Integer rows = 5;
        Board board = new Board(rows, 0);
        //Act
        Integer numberOfRows = board.rows();
        //Assert
        assertEquals("The number of rows is not the same which was injected", rows, numberOfRows);
    }

    @Test
    public void checkWidthOfBoard(){
        //Arrange
        final Integer columns = 5;
        Board board = new Board(1, columns);
        //Act
        Integer numberOfRows = board.columns();
        //Assert
        assertEquals("The number of columns is not the same which was injected", columns, numberOfRows);
    }
    
    @Test
    public void boardEmptyRecoverADieCell(){
        //Arrange
        final Cell cell= Cell.DIE;
        Board board = new Board(5, 5);
        Coordinate any = new Coordinate(0, 0);
        //Act
        Cell result = board.recoverCell(any);
        //Assert
        assertEquals("The cell is not death", cell, result);
    }

    @Test
    public void changeCellToAliveAndRecoverThisCell(){
        //Arrange
        final Cell cell= Cell.ALIVE;
        Board board = new Board(5, 5);
        Coordinate any = new Coordinate(0, 0);
        //Act
        board.changeCell(any, cell);
        Cell result = board.recoverCell(any);
        //Assert
        assertEquals("The cell is not alive", cell, result);
    }

    @Test
    public void changeCellToDieAndRecoverThisCell(){
        //Arrange
        final Cell cell_expected= Cell.DIE;
        Board board = new Board(5, 5);
        Coordinate any = new Coordinate(0, 0);
        board.changeCell(any, Cell.ALIVE);
        //Act
        board.changeCell(any, cell_expected);
        Cell result = board.recoverCell(any);
        //Assert
        assertEquals("The cell is alive", cell_expected, result);
    }

    @Test
    public void compareDifferentsBoardsWithTheSameValuesReturnTrue(){
        //Arrange
        Board board1 = new Board(5, 5);
        board1.changeCell(new Coordinate(1,1), Cell.DIE);
        Board board2 = new Board(5, 5);
        board2.changeCell(new Coordinate(1,1), Cell.DIE);
        //Act
        boolean areEquals = board1.equals(board2);
        //Assert
        assertTrue("Are not equals", areEquals);
    }

    @Test
    public void compareDifferentsBoardsWithDifferentsValuesReturnFalse(){
        //Arrange
        Board board1 = new Board(5, 5);
        board1.changeCell(new Coordinate(1,1), Cell.DIE);
        Board board2 = new Board(5, 5);
        board2.changeCell(new Coordinate(1,1), Cell.ALIVE);
        //Act
        boolean areNotEquals = !board1.equals(board2);
        //Assert
        assertTrue("Are not equals", areNotEquals);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void tryToRecoverACoordinateOutOfTheBoardReturnAnError(){
        //Arrange
        Coordinate outOfTheLimit = new Coordinate(10, 0);
        Board board = new Board(5, 5);
        //Act
        board.recoverCell(outOfTheLimit);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void tryTochangeACoordinateOutOfTheBoardReturnAnError(){
        //Arrange
        final Cell cell_expected= Cell.DIE;
        Board board = new Board(5, 5);
        Coordinate outOfTheLimit = new Coordinate(10, 0);
        //Act
        board.changeCell(outOfTheLimit, cell_expected);
    }

    @Test
    public void extractNeighboursOfTheCenterCellWithRangeOne(){
        //Arrange
        final Coordinate centerCell = new Coordinate(2, 2);
        Board board = new Board(5,5);
        board.changeCell(new Coordinate(1,1), Cell.DIE);
        AroundCells aroundCells = new AroundCells(board.recoverCell(centerCell), Arrays.asList(
                board.recoverCell(new Coordinate(1,1)),
                board.recoverCell(new Coordinate(1,2)),
                board.recoverCell(new Coordinate(1,3)),
                board.recoverCell(new Coordinate(2,1)),
                board.recoverCell(new Coordinate(2,2)),
                board.recoverCell(new Coordinate(2,3)),
                board.recoverCell(new Coordinate(3,1)),
                board.recoverCell(new Coordinate(3,2)),
                board.recoverCell(new Coordinate(3,3))
        ));
        //Act
        AroundCells cells = board.neightbours(centerCell, 1);
        //Assert
        assertEquals("Not return the same cells", aroundCells, cells);
    }
    
}
