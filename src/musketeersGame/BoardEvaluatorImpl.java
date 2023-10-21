package musketeersGame;

public class BoardEvaluatorImpl implements BoardEvaluator {

    /**
     * Calculates a score for the given Board
     * A higher score means the Musketeer is winning
     * A lower score means the Guard is winning
     * Add heuristics to generate a score given a Board
     * @param board Board to calculate the score of
     * @return int Score of the given Board
     */
    @Override
    public int evaluateBoard(Board board) {
        var mList = board.getPossibleMoves();
        for (Move m: mList) {
            if(m.toCell.getCoordinate().row < m.fromCell.getCoordinate().row){
                return (board.size * board.size) - (board.getGuardCells().size() + 3) ;
            }
            else if (m.toCell.getCoordinate().col > m.fromCell.getCoordinate().col)
                return (board.size * board.size) - (board.getGuardCells().size() -3);
            else
                return (board.size * board.size) - (board.getGuardCells().size());
        }

    return 0;}
}
