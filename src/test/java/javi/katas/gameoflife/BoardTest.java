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
        Board board = new Board(0, columns);
        //Act
        Integer numberOfRows = board.columns();
        //Assert
        assertEquals("The number of columns is not the same which was injected", columns, numberOfRows);
    }
}
