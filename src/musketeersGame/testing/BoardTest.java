package musketeersGame.testing;

import org.junit.*;

import musketeersGame.Board;
import musketeersGame.Cell;
import musketeersGame.Coordinate;

public class BoardTest {

    private Board board;

    @Before
    public void setup() {
        this.board = new Board();
    }

    @Test
    public void testGetCell() {
        Cell cell = board.getCell(new Coordinate(1, 4));
        Assert.assertNotNull(cell.getPiece());
    }

}
