package questions;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test For true False Class.
 */

public class TrueFalseTest {
  private TrueFalse tf1;

  @Before
  public void setup() {

    tf1 = new TrueFalse("Your day is good?", "1", "2", "1");
  }

  @Test
  public void testAnswer() {
    assertEquals("Incorrect", tf1.answer("2"));
  }

  @Test
  public void testAnswer1() {
    assertEquals("Correct", tf1.answer("1"));
  }

  @Test
  public void testGetText() {
    assertEquals("Your day is good?", tf1.getText());
  }

  @Test
  public void testCompareTo() {
    assertEquals(0, tf1.compareTo(tf1));
  }

  @Test
  public void testCompareTo1() {
    Likert l1;
    l1 = new Likert("How was your day?");
    assertEquals(0, l1.compareTo(l1));
  }

  @Test
  public void testCompareTo2() {
    MultipleChoice mc1;
    mc1 = new MultipleChoice("Your day is good?", "1", "2", "3", "1");
    assertEquals(0, mc1.compareTo(mc1));
  }

  @Test
  public void testCompareTo3() {
    MultipleSelect ms1;
    ms1 = new MultipleSelect("Your day is good?", "1 2", "1", "2", "3");
    assertEquals(0, ms1.compareTo(ms1));
  }
}
