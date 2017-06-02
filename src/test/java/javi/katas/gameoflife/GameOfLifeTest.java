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
        final Coordinate center = new Coordinate(0, 0);
        board.changeCell(center, Cell.ALIVE);
        //Act
        gameOfLife.execute(1);
        //Assert
        Board boardResult = gameOfLife.recoverBoard();
        assertEquals("The board result isn't empty", emptyBoard, boardResult);
    }

    @Test
    public void cellWithOneNeighbourDie(){
        //Arrange
        Board emptyBoard = new Board(5,5);
        final Coordinate center = new Coordinate(0, 0);
        board.changeCell(center, Cell.ALIVE);
        board.changeCell(new Coordinate(0,1), Cell.ALIVE);
        //Act
        gameOfLife.execute(1);
        //Assert
        Board boardResult = gameOfLife.recoverBoard();
        assertEquals("The board result isn't empty", emptyBoard, boardResult);
    }

    @Test
    public void cellWithFourNeighboursDie(){
        //Arrange
        Board boardExpected = new Board(5,5);
        boardExpected.changeCell(new Coordinate(1,1), Cell.ALIVE);
        boardExpected.changeCell(new Coordinate(1,2), Cell.ALIVE);
        boardExpected.changeCell(new Coordinate(1,3), Cell.ALIVE);
        boardExpected.changeCell(new Coordinate(2,1), Cell.ALIVE);

        final Coordinate center = new Coordinate(2, 2);
        board.changeCell(center, Cell.ALIVE);
        board.changeCell(new Coordinate(1,1), Cell.ALIVE);
        board.changeCell(new Coordinate(1,2), Cell.ALIVE);
        board.changeCell(new Coordinate(1,3), Cell.ALIVE);
        board.changeCell(new Coordinate(2,1), Cell.ALIVE);
        //Act
        gameOfLife.execute(1);
        //Assert
        Board boardResult = gameOfLife.recoverBoard();
        assertEquals("The board result isn't empty", boardExpected, boardResult);
    }
}
