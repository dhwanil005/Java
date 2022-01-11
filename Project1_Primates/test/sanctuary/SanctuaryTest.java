package sanctuary;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
 
/**
 *testing sanctuary.
 */

public class SanctuaryTest {
  private Sanctuary s1;
  
  /**
 * setup.
 */

  @Before
public void setup() {
    s1 =  new Sanctuary(400, 52);
  }
  /**
   * testing for illegalargumentexception.
   */
  
  @Test (expected = IllegalArgumentException.class)
  public void testSanctuary() {
    s1 = new Sanctuary(-300, 40);
  }
  /**
   * testing number of monkeys.
   */
  
  @Test
  public void monkeysInSanctuary() {
    assertEquals("Total Number Of Monkeys in the Sanctuary is 400", s1.monkeysInSanctuary());
  }
  /**
   * testing number of troops.
   */
  
  @Test
  public void testTotalTroops() {
    assertEquals("Total Number Of Monkeys in the Sanctuary is:", s1.totalTroops());
  }
  /**
   * testing localtion of monkey.
   */
  
  @Test
  public void testLocateMonkey(String name) {
    assertEquals("Monkey named: Mark is currently in: Isolation", s1.locateMonkey(name));
  }
  
  
  
}
