package gametest;

import static org.junit.Assert.assertEquals;

import battlearena.Arena;
import battlearena.Player;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for arena class.
 */
public class ArenaTest {
  Arena a1;
  Player p1;
  Player p2;

  /**
   * setup.
   */
  @Before
  public void setup() {
    a1 = new Arena();
    p1 = new Player("Dhwanil");
    p2 = new Player("Abhi");

  }

  /**
   * Testing for get turn.
   */
  @Test
  public void testGetTurn() {
    a1.enterArena(p1, p2);
    assertEquals(p1, a1.getTurn(p1, p2));

  }

}
