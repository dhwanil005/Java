package gametest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import battlearena.Gear;
import battlearena.Player;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for gear class.
 */

public class GearTest {
  /**
   * Setup.
   */
  Gear g1;

  @Before
  public void setup() {
    g1 = new Gear();
  }

  /**
   * Testing gear Assign.
   */

  @Test
  public void testGearAssign() {
    Gear g2 = new Gear();
    g2.gearAssign();

    assertEquals(1, g2.getCountForHeadgear());
    int s = g2.getCountForPotions();
    assertTrue(s >= 2 && s <= 18);
    int v = g2.getCountForBelts();
    assertTrue(v >= 2 && v <= 18);
    assertEquals(1, g2.getCountForFootwear());

  }

  /**
   * testing calculations.
   */
  @Test
  public void testCalculation() {
    Gear g2 = new Gear();
    Player p1 = new Player("Dhwanil");
    g2.calculations(p1);
    int sa = g2.getStrengthAffected();
    assertTrue(sa >= 7 && sa <= 28);
    int cha = g2.getCharsimaAffected();
    assertTrue(cha >= 7 && cha <= 36);
    int da = g2.getDexterityAffected();
    assertTrue(da >= 7 && da <= 28);
    int ca = g2.getConstitutionAffected();
    assertTrue(ca >= 7 && ca <= 36);

  }
}