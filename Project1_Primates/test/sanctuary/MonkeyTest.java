package sanctuary;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for Monkey Class.
 */
public class MonkeyTest {
  private Monkey m1;
  /**
   * Setup.
   */
  
  @Before
  public void setup() {
    m1 = new Monkey("Mark", "Guereza", "Female", "Fruits", 20, "Medium", 1, "Enclosure");
  }
  /**
   *Testing for illegalargumentexception. 
   */
  
  @Test (expected = IllegalArgumentException.class)
  public void monkeyTest() {
    new Monkey("Mark", "Guereza", "Female", "Fruits", -20, "Extra Large", -1, "Home");
  }
  /**
   *testing name.
   */
  
  @Test 
  public void testName() {
    String s = m1.getName();
    assertEquals("Mark", s);
  }
  
  
  /**
   *testing sex.
   */
  
  @Test 
    public void testSex() {
    String s = m1.getSex();
    assertEquals("Female", s);
  }
  /**
     * testing housing type.
     */
  
  @Test 
    public void testHousingType() {
    String s = m1.getHousingType();
    assertEquals("Enclosure", s);
  }
  
  /**
   * testing fav food.
   */
  
  @Test 
  public void testFavFood() {
    String s = m1.getFavFood();
    assertEquals("Fruits", s);
  }
  /**
   * testing size.
   */
  
  @Test 
  public void testSize() {
    String s = m1.getSize();
    assertEquals("Medium", s);
  }

}
