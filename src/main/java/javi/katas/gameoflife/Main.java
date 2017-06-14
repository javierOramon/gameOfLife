package javi.katas.gameoflife;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String [ ] args){

        System.out.println("Welcome to the Game Of Life");
        Board board = buildBoard();
        GameOfLife game = new GameOfLife(board, new TransformerCell());
        iterateWithTheGame(game);
        System.out.println("Bye!!");
    }

    private static void iterateWithTheGame(GameOfLife game) {
        Painter painter = new Painter(new PainterCell());
        Integer count = 0;
        boolean continueMore = true;
        while(continueMore) {
            count++;
            System.out.println("This is the iteration number " + count);
            String consoleBoard = painter.paint(game.board());
            System.out.println(consoleBoard);
            continueMore = requireApprovation("Do you want iterate more?");
            game = game.execute();
        }

    }

    private static Board buildBoard() {
        Board board = buildBaseBoard();
        System.out.println("You should indicate the alive cells");
        boolean putMore = true;
        while (putMore){
            insertAnAliveCell(board);
            putMore = shouldContinuePuttingAliveCells();
        }

        return board;
    }

    private static boolean shouldContinuePuttingAliveCells() {
        final String sentence = "Do you want continue putting more cells? Y,N";
        return requireApprovation(sentence);
    }

    public static boolean requireApprovation(String sentence){
        boolean finish = false;
        System.out.println(sentence);
        String response = scanner.next();
        if("y".equals(response.toLowerCase())){
            finish = true;
        }
        return finish;
    }

    private static void insertAnAliveCell(Board board) {
        System.out.println("Indicate row");
        Integer row = scanner.nextInt();
        System.out.println("Indicate column");
        Integer column = scanner.nextInt();
        board.changeCell(new Coordinate(row, column), Cell.ALIVE);
    }

    private static Board buildBaseBoard() {
        System.out.println("Indicate the number of rows");
        Integer rows =  scanner.nextInt();
        System.out.println("Indicate the number of columns");
        Integer columns = scanner.nextInt();
        return new Board(rows, columns);
    }
}
