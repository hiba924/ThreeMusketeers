package assignment1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HumanAgent extends Agent {

    public HumanAgent(Board board) {
        super(board);
    }
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Asks the human for a move with from and to coordinates and makes sure its valid.
     * Create a Move object with the chosen fromCell and toCell
     * @return the valid human inputted Move
     */
    @Override
    public Move getMove() { // TODO
        var inputCoordinate = getInputOption();
        var fromCoordinateRow = inputCoordinate.charAt(0);
        var fromCoordinateCol = inputCoordinate.substring(1,2) ;
        var toCoordinateRow = inputCoordinate.charAt(3);
        var toCoordinateCol = inputCoordinate.substring(4,5);
        int position1 = fromCoordinateRow - 'A';
        int position2 = toCoordinateRow - 'A';

        Cell fromCell = board.getCell(new Coordinate(Integer.parseInt(fromCoordinateCol) -1 ,position1));
        Cell toCell = board.getCell(new Coordinate(Integer.parseInt(toCoordinateCol) - 1,position2));
        Move move = new Move(fromCell,toCell);
        if (board.isValidMove(move))
            return move;
        else {
            System.out.println("Please enter a valid move for your piece");
            return getMove();
        }
    }


    private String getInputOption() {
        System.out.printf("[%s] Please enter the coordinate of which piece you want to move: ", board.getTurn().getType());
        // var pattern = Pattern.compile("[a-eA-E][1-5][ ][a-eA-E][1-5]");
        var pattern = Pattern.compile("[a-eA-E][1-5] [a-eA-E][1-5]");
        var nextLine = "" ;
        while (true) {
            nextLine = scanner.nextLine();
            if (! pattern.matcher(nextLine).find()) {
                System.out.print("Invalid option. Please enter 2 valid coordinate with a space in between, valid coordinates are A1 through E5 : ");
            } else {
                break;
            }
        }
        return nextLine.toUpperCase();

    }
}
