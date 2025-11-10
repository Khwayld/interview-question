import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Test;

public class Connect4Test {
    @Test
    public void testConnect4() {
        Connect4 c4 = createDefaultGame();

        for (int i = 0; i < c4.getWidth(); i++) {
            for (int j = 0; j < c4.getHeight(); j++) {
                if (c4.getPieceAt(j, j) != null) {
                    assertThat(c4.getPieceAt(j, j), equalTo(Piece.RED));
                } else {
                    assertThat(c4.getPieceAt(j, j), nullValue());
                }
            }
        }

        if (!c4.isGameOver()) {
            c4.drop(Piece.RED, 0);
        }

        assertThat(c4.whoseTurn(), equalTo(Piece.YELLOW));
        assertThat(c4.isGameOver(), equalTo(true));
        assertThat(c4.getWinner(), equalTo(Piece.RED));
    }

    private Connect4 createDefaultGame() {
        Connect4 c4 = new Connect4(7, 6);
        for (int i = 0; i < 10; i++) {
            c4.drop(i % 2 == 0 ? Piece.RED : Piece.YELLOW, i % 7);
        }
        return c4;
    }
}