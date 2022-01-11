package polynomial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * class for testing monomials.
 */
public class PolyTest {

  @Before
  public void setUp() {
    Polynomial poly;
    poly = new PolynomialImpl("5x^2 +2x^1 +1");
  }

  @Test
  public void testPolynomial() {
    PolynomialImpl p = new PolynomialImpl("-10x^3 +5x^2 +7x^1 +9");
    PolynomialImpl p1 = new PolynomialImpl("-10x^3 +5x^2 +7x^1 +9");
    PolynomialImpl a = new PolynomialImpl("15x^3 -23x^2 +5x^1 +10");

    assertEquals(true, p.isSame(p1));
    assertTrue(p1.isSame(p));
    assertEquals(15, a.getCoefficient(3));
    PolynomialImpl b = new PolynomialImpl("2x^4 +1 +3x^2");
    assertEquals(45, b.evaluate(2), 2);
    assertEquals(4, b.getDegree());
    assertEquals("17x^4 +15x^3 -20x^2 +5x^1 +10", a.add(b));

  }

  @Test
  public void testToString() {
    String x = "3x^5+1";
    Polynomial poly = new PolynomialImpl(x);
    assertEquals(x, poly.toString());

  }
}
