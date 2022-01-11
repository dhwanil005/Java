package gametest;

import static org.junit.Assert.assertTrue;

import battlearena.Player;
import org.junit.Before;
import org.junit.Test;

/**
 * Class for testing player.
 * 
 */
public class PlayerTest {
  Player p1;

  /**
   * setting up.
   */
  @Before
  public void setUp() {
    p1 = new Player("Dhwanil");
  }

  /**
   * Testing basic abilities.
   */
  @Test
  public void testBasicAbilities() {
    Player p2 = new Player("Abhi");
    int s = p2.getStrength();
    assertTrue(s >= 6 && s <= 18);
    int c = p2.getConstitution();
    assertTrue(c >= 6 && c <= 18);
    int d = p2.getDexterity();
    assertTrue(d >= 6 && d <= 18);
    int ch = p2.getCharisma();
    assertTrue(ch >= 6 && ch <= 18);
  }

  /**
   * Testing striking power.
   */

  @Test
  public void testStrikingPower() {
    Player p2 = new Player("Abhi");
    int sp = p2.calculateStrikingPower();
    assertTrue(sp >= 7 && sp <= 46);
  }

  /**
   * testing health.
   */
  @Test
  public void testHealth() {
    Player p2 = new Player("Abhi");
    p2.calculateHealth();
    int h = p2.getHealth();
    assertTrue(h >= 24 && h <= 72);
  }

  /**
   * testing avoidance ability.
   */
  @Test
  public void testAvoidanceAbility() {
    Player p2 = new Player("Abhi");
    int caa = p2.calculateAvoidanceAbility();
    assertTrue(caa >= 7 && caa <= 40);

  }

  /**
   * Testing potential striking damage.
   */
  @Test
  public void testPsd() {
    Player p2 = new Player("Abhi");
    p2.calculatePotentialStrikingDamage();
    int psd = p2.getPsd();
    assertTrue(psd >= 10 && psd <= 30);
  }
}
