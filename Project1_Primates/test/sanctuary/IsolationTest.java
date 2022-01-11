package sanctuary;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * testing isolaton test.
 */

public class IsolationTest {
  private Isolation i1;
  /**
 * setup.
 */
  
  @Before
  public void setup() {
    i1 =  new Isolation(5, 2, false);
  }
  /**
   * Testing for illegalargumentexception. 
   */
  
  @Test (expected = IllegalArgumentException.class)
  public void isolationTest() {
    i1 = new Isolation(-4, 3, true);
  }
  /**
   * testing availability.
   */
  
  @Test
  public void testAvailability() {
    assertEquals(true, i1.availablity(10));
  }
  
}
