package questions;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for MCQ Class.
 */
public class MultipleChoiceTest {
  private Question mc1;

  @Before
  public void setup() {
    mc1 = new MultipleChoice("How many provinces are there in canada?", "1", "2", "3", "1");
  }

  @Test
  public void testAnswer() {
    assertEquals("Incorrect", mc1.answer("9"));
  }

  @Test
  public void testAnswer1() {
    assertEquals("Correct", mc1.answer("1"));
  }

  @Test
  public void testGetText() {
    assertEquals("How many provinces are there in canada?", mc1.getText());
  }

  @Test
  public void testCompareTo() {
    assertEquals(0, mc1.compareTo(mc1));
  }

  @Test
  public void testCompareTo1() {
    Likert l1;
    l1 = new Likert("How was your day?");
    assertEquals(0, l1.compareTo(l1));
  }

  @Test
  public void testCompareTo2() {
    TrueFalse tf1;
    tf1 = new TrueFalse("Your day is good?", "1", "2", "1");
    assertEquals(0, tf1.compareTo(tf1));
  }

  @Test
  public void testCompareTo3() {
    MultipleSelect ms1;
    ms1 = new MultipleSelect("Your day is good?", "1", "2", "3", "1 2");
    assertEquals(0, ms1.compareTo(ms1));
  }
}
