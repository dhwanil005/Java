package questions;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for class likert.
 */
public class LikertTest {
  private Question l1;

  @Before
  public void setup() {
    l1 = new Likert("How was your day?");
  }

  @Test
  public void testAnswer() {
    assertEquals("Incorrect", l1.answer("6"));
  }

  @Test
  public void testAnswer1() {
    assertEquals("Correct", l1.answer("3"));
  }

  @Test
  public void testGetText() {
    assertEquals("How was your day?", l1.getText());
  }

  @Test
  public void testCompareTo() {
    assertEquals(0, l1.compareTo(l1));
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
    MultipleSelect ms1;
    ms1 = new MultipleSelect("Your day is good?", "1 2", "1", "2", "3");
    assertEquals(0, ms1.compareTo(ms1));
  }
}
