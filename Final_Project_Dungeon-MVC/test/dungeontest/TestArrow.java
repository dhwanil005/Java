package dungeontest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dungeon.Arrows;
import dungeon.Dungeon;
import dungeon.Monster;
import dungeon.Player;

/**
 * Testing for arrow.
 */
public class TestArrow {
  Arrows a = new Arrows();
  Dungeon d = new Dungeon(6, 8, 20, 1, false, 1);
  Player p = new Player("d");
  Monster m = new Monster();

  @Test
  public void testHitOrNot() {
    int end = d.endPoint();
    p.attackMonster(end - 2, "EAST", 1, d, m);
    assertEquals(false, p.gethitOrNot());
  }

}
