package sanctuary;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


/**
 * Test Enclosure.
 */

public class EnclosureTest {
  private Enclosure e1;
  /**
   *Setup. 
   */
  
  @Before
  public void setup() {
    new Enclosure(true, 3, 20, 5);
  }
  /**
   *Testing for illegalargumentexception. 
   */
  
  @Test (expected = IllegalArgumentException.class)
  public void enclosureTest() {
    new Enclosure(true, 0, -20, -5);
  }
  /**
   *Testing Availability and illegalexceptionargument.
   */
  
  @Test
  public void testAvailability() {
    assertEquals("Cells Available", e1.roomAvailable());
  }
}
