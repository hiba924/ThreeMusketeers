package assignment1;

import java.sql.SQLOutput;
import java.util.Random;

public class RandomAgent extends Agent {

    public RandomAgent(Board board) {
        super(board);
    }

    /**
     * Gets a valid random move the RandomAgent can do.
     * @return a valid Move that the RandomAgent can perform on the Board
     */
    @Override
    public Move getMove() { // TODO
        var randomMoves = board.getPossibleMoves();
        var length = randomMoves.size();
        Random rand = new Random();
        int randomNumber = rand.nextInt(length);
        Move m = randomMoves.get(randomNumber);
        return m;

    }
}
