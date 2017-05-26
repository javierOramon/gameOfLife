package javi.katas.gameoflife;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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


    
}
