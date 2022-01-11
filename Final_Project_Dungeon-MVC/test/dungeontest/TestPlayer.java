package dungeontest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dungeon.Player;

/**
 * Test class for Player Class.
 */

public class TestPlayer {
  private Player p1;

  @Before
  public void setup() {
    p1 = new Player("D");

  }

  @Test
  public void testName() {
    assertEquals("D", p1.getName());
  }

}
