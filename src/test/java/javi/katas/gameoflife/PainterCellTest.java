package javi.katas.gameoflife;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PainterCellTest {

    private PainterCell painter;

    @Before
    public void setUp(){
        painter = new PainterCell();
    }

    @Test
    public void cellDiePaintAsterisk(){
        //Arrange
        final String expected = "*";
        Cell die = Cell.DIE;
        //Act
        String symbol = painter.paint(die);
        //Assert
        assertEquals("Cell doesn' paint an asterisk", expected, symbol);
    }
}
