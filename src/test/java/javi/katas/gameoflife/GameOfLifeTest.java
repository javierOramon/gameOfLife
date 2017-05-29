package javi.katas.gameoflife;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameOfLifeTest {

    private Board board;
    private GameOfLife gameOfLife;

    @Before
    public void setUp(){
        board = new Board(5,5);
        gameOfLife = new GameOfLife(board);
    }

    @Test
    public void recoverBoardReturnsTheCurrentBoard(){
        //Arrange
        //Act
        Board boardResult = gameOfLife.recoverBoard();
        //Assert
        assertEquals("Is not the same board", board, boardResult);
    }

    @Test
    public void cellWithoutNeighboursDie(){
        //Arrange
        Board emptyBoard = new Board(5,5);
        final Coordinate any = new Coordinate(0, 0);
        board.changeCell(any, Cell.ALIVE);
        //Act
        gameOfLife.execute();
        //Assert
        Board boardResult = gameOfLife.recoverBoard();
        assertEquals("The board result isn't empty", emptyBoard, boardResult);
    }
}
