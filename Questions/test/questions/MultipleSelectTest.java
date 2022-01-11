package questions;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * test for Multiple Select Class.
 */
public class MultipleSelectTest {
  private Question ms2;

  @Before
  public void setup() {
    ms2 = new MultipleSelect("Your day is good?", "1 2", "1", "2", "3");
  }

  @Test
  public void testAnswer() {
    assertEquals("Incorrect", ms2.answer("1"));
  }

  @Test
  public void testAnswer1() {
    assertEquals("Correct", ms2.answer("1 2"));
  }

  @Test
  public void testGetText() {
    assertEquals("Your day is good?", ms2.getText());
  }

  @Test
  public void testCompareTo() {
    assertEquals(0, ms2.compareTo(ms2));
  }

  @Test
  public void testCompareTo1() {
    TrueFalse tf1;
    tf1 = new TrueFalse("Your day is good?", "1", "2", "1");
    assertEquals(0, tf1.compareTo(tf1));
  }

  @Test
  public void testCompareTo2() {
    MultipleChoice mc1;
    mc1 = new MultipleChoice("Your day is good?", "1", "2", "3", "1");
    assertEquals(0, mc1.compareTo(mc1));
  }

  @Test
  public void testCompareTo3() {
    Likert l1;
    l1 = new Likert("How was your day?");
    assertEquals(0, l1.compareTo(l1));
  }
}
