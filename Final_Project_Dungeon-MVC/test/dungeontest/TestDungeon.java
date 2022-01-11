package dungeontest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import dungeon.Dungeon;

/**
 * Test Class For Dungeon Class.
 * 
 */
public class TestDungeon {
  private Dungeon d1;

  @Before
  public void setup() {
    d1 = new Dungeon(6, 8, 2, 20, false, 1);
  }

  @Test
  public void testStartPoint() {

    assertTrue(d1.startPoint() > 0 && d1.startPoint() < 5);

  }

  @Test
  public void testRows() {
    assertEquals(6, d1.getRows());
  }

  @Test
  public void testColumns() {
    assertEquals(8, d1.getColumns());
  }

  @Test
  public void testInterConnectivity() {
    assertEquals(2, d1.getInterConnectivity());
  }

  @Test
  public void testTreasureAvailability() {
    assertEquals(20, d1.getTreasureAndArrowAvailability());
  }

  @Test
  public void testDirections() {
    ArrayList<String> dr = d1.possibleMoves(10);
    assertTrue(dr.size() >= 0 && dr.size() < 11);
  }

}
