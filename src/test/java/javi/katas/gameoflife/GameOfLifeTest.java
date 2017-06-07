package javi.katas.gameoflife;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameOfLifeTest {

    private Board board;
    private TransformerCell transformer;
    private GameOfLife gameOfLife;

    @Before
    public void setUp(){
        board = new Board(5, 5);
        transformer = new TransformerCell();
        gameOfLife = new GameOfLife(board, transformer);
    }

    @Test
    public void cellDieAndLeaveAnEmptyBoard(){
        //Arrange
        Board emptyBoard = new Board(5, 5);
        board.changeCell(new Coordinate(2,2), Cell.ALIVE);
        //Act
        gameOfLife.execute();
        //Assert
        assertEquals("The board is not empty", emptyBoard, board);
    }
}
