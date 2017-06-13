package javi.katas.gameoflife;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PainterTest {

    private Painter painter;

    @Before
    public void setUp(){
        painter = new Painter(new PainterCell());
    }

    @Test
    public void printEmptyBoard(){
        //Arrange
        final String expected = "**\n**\n";
        Board board = new Board(2,2);
        //Act
        String result = painter.paint(board);
        //Assert
        assertEquals("The result is not correct", expected, result);
    }

    @Test
    public void printAliveCornersBoard(){
        //Arrange
        final String expected = "o*\n*o\n";
        Board board = new Board(2,2);
        board.changeCell(new Coordinate(0,0), Cell.ALIVE);
        board.changeCell(new Coordinate(1,1), Cell.ALIVE);
        //Act
        String result = painter.paint(board);
        //Assert
        assertEquals("The result is not correct", expected, result);
    }
}
