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
    public void emptyBoardReturnAnEmptyBoard(){
        //Arrange
        GameOfLife gameExpected = new GameOfLife(new Board(5,5), transformer);
        //Act
        GameOfLife newGame = gameOfLife.execute();
        //Assert
        assertEquals("The board is not empty", gameExpected, newGame);
    }

    @Test
    public void cellAliveWithoutNeightboursReturnAnEmptyBoard(){
        //Arrange
        GameOfLife gameExpected = new GameOfLife(new Board(5,5), transformer);
        board.changeCell(new Coordinate(2,2), Cell.ALIVE);
        //Act
        GameOfLife newGame = gameOfLife.execute();
        //Assert
        assertEquals("The board is not empty", gameExpected, newGame);
    }

    @Test
    public void cellAliveWithOneAliveNeightbourReturnAnEmptyBoard(){
        //Arrange
        GameOfLife gameExpected = new GameOfLife(new Board(5,5), transformer);
        board.changeCell(new Coordinate(2,2), Cell.ALIVE);
        board.changeCell(new Coordinate(2,3), Cell.ALIVE);
        //Act
        GameOfLife newGame = gameOfLife.execute();
        //Assert
        assertEquals("The board is not empty", gameExpected, newGame);
    }

    @Test
    public void cellAliveWithTwoNeightboursSurvive(){
        //Arrange
        Board expectedBoard = new Board(5, 5);
        expectedBoard.changeCell(new Coordinate(1,2), Cell.ALIVE);
        expectedBoard.changeCell(new Coordinate(2,2), Cell.ALIVE);
        expectedBoard.changeCell(new Coordinate(3,2), Cell.ALIVE);
        GameOfLife gameExpected = new GameOfLife(expectedBoard, transformer);
        board.changeCell(new Coordinate(2,2), Cell.ALIVE);
        board.changeCell(new Coordinate(2,1), Cell.ALIVE);
        board.changeCell(new Coordinate(2,3), Cell.ALIVE);
        //Act
        GameOfLife newGame = gameOfLife.execute();
        //Assert
        assertEquals("The board is not empty", gameExpected, newGame);
    }
}
