package polynomial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * class for testing monomials.
 */
public class PolyTest {
  private Polynomial poly;

  @Before
  public void setUp() {
    this.poly = new Polynomials("5x^2 +2x^1 +1");
  }

  @Test
  public void testPolynomial() {
    Polynomials p = new Polynomials("-10x^3 +5x^2 +7x^1 +9");
    Polynomials p1 = new Polynomials("-10x^3 +5x^2 +7x^1 +9");
    Polynomials a = new Polynomials("15x^3 -23x^2 +5x^1 +10");
    Polynomials b = new Polynomials("2x^4 +1 +3x^2");

    assertEquals(true,p.isSame(p1));
    assertTrue(p1.isSame(p));
    assertEquals(15, a.getCoefficient(3));
    assertEquals(45, b.evaluate(2), 2);
    //assertEquals("17x^4 +15x^3 -20x^2 +5x^1 +10", a.add(b));
    assertEquals(4, b.getDegree());
    
  }

}
