package gametest;

import static org.junit.Assert.assertTrue;

import battlearena.Player;
import battlearena.Weapon;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;


/**
 * class for testing weapon class.
 */

public class WeaponTest {
  Weapon w1;
  Player p1;

  @Before
  public void setup() {
    w1 = new Weapon();
    p1 = new Player("Abhi");
  }

  @Test
  public void testGetWeapon() {
    ArrayList<String> weapons = new ArrayList<String>();
    weapons.add("Katana");
    weapons.add("Broadswords");
    weapons.add("Two-Handed Swords");
    weapons.add("Flail");
    weapons.add("Axe");
    String weapon = w1.getRandomWeapon();
    assertTrue(weapons.contains(weapon));

  }

  @Test
  public void testCalculateDamage() {
    String s = w1.getRandomWeapon();
    int wd = w1.weaponRandomValue(s, p1);
    assertTrue(wd >= 4 && wd <= 12);

  }
}
