package transmission;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/** 
 * Testing Class.
 *
 */
public class AutomaticTransmissionTest {
  private AutomaticTransmission at;
  private AutomaticTransmission bt;
  private AutomaticTransmission ct;
  
  @Before
public void setup() {
    at = new AutomaticTransmission(1, 40, 70, 90, 110);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void automaticTransmissiontest() {
    new AutomaticTransmission(-10, 30, 50, 78, 0);
  }
  
  @Test
  public void testSpeed() {
    int s;
    at.increaseSpeed();
    s = at.getSpeed();
    assertEquals(1, s);
  }
  
  @Test
  public void testGear() {
    int g;
    for (int i = 0; i < 110; i++) {
      at.increaseSpeed();
    }
    g = at.getGear();
    assertEquals(6, g);
  }
  
  @Test(expected = IllegalStateException.class)
    public void decreaseTest() {
    int d;
    at.decreaseSpeed();
    d = at.getSpeed();
    assertEquals(0, d);
  }
  
  @Test
    public void testDecrease() {
    int dd;
    for (int i = 0; i < 110; i++) {
      at.increaseSpeed();
    }
    at.decreaseSpeed();
    dd = at.getSpeed();
    assertEquals(109, dd);
  }
  
  @Test
  public void testString() {
    assertEquals("Transmission (speed=" + 0 + ", gear=" + 0 + ")", at.toString());
  }
  
  @Test
    public void  testEquals() {
    bt = new AutomaticTransmission(1, 40, 70, 90, 110);
    ct = new AutomaticTransmission(1, 40, 70, 90, 110);
    assertEquals(true, bt.equals(ct));
  }
  
  @Test
  public void testNotEquals() {
    bt = new AutomaticTransmission(1, 40, 70, 90, 110);
    ct = new AutomaticTransmission(1, 40, 70, 00, 110);
    assertEquals(false, bt.equals(ct));
  }
}
