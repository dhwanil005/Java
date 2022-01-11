import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.NoSuchElementException;
import lookandsay.LookAndSayIterator;
import lookandsay.RIterator;
import org.junit.Test;

/**
 * Testing class for all the possible tests to make sure the program runs
 * perfecrly.
 */
public class TestLookAndSay {

  @Test(expected = IllegalArgumentException.class)
  public void testConst() {
    BigInteger seed = new BigInteger("-3");
    BigInteger max = new BigInteger("4");
    RIterator<BigInteger> test = new LookAndSayIterator(seed, max);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testConst1() {
    BigInteger seed = new BigInteger("51375481");
    BigInteger max = new BigInteger("4000000");
    RIterator<BigInteger> test = new LookAndSayIterator(seed, max);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testConst2() {
    BigInteger seed = new BigInteger("10");
    BigInteger max = new BigInteger("1100000");
    RIterator<BigInteger> test = new LookAndSayIterator(seed, max);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testConst3() {
    BigInteger seed = new BigInteger("-3");

    RIterator<BigInteger> test = new LookAndSayIterator(seed);

  }

  @Test
  public void testNext() {
    BigInteger seed = new BigInteger("123");
    BigInteger max = new BigInteger("100000000000");
    RIterator<BigInteger> test = new LookAndSayIterator(seed, max);
    BigInteger g = test.next();
    assertEquals("123", g.toString());
    BigInteger x = test.next();
    assertEquals("111213", x.toString());

  }

  @Test(expected = NoSuchElementException.class)
  public void testNoSuchNext() {
    BigInteger seed = new BigInteger("1234");
    BigInteger max = new BigInteger("10000");
    RIterator<BigInteger> test = new LookAndSayIterator(seed, max);
    test.next();
    test.next();

  }

  @Test
  public void testPrevious() {
    BigInteger seed = new BigInteger("123");
    BigInteger max = new BigInteger("100000000000");
    RIterator<BigInteger> test = new LookAndSayIterator(seed, max);
    test.next();
    test.next();
    BigInteger g = test.previous();
    assertEquals("123", g.toString());

  }

  @Test(expected = NoSuchElementException.class)
  public void testNoSuchPrev() {
    BigInteger seed = new BigInteger("123");
    BigInteger max = new BigInteger("100000000000");
    RIterator<BigInteger> test = new LookAndSayIterator(seed, max);
    test.next();
    test.next();
    test.previous();
    test.previous();

  }

  @Test
  public void testHasNextTrue() {
    BigInteger seed = new BigInteger("1234");
    BigInteger max = new BigInteger("100000000000");
    RIterator<BigInteger> test = new LookAndSayIterator(seed, max);
    assertEquals(true, test.hasNext());
  }

  @Test
  public void testHasNextFalse() {
    BigInteger seed = new BigInteger("123");
    BigInteger max = new BigInteger("1000000");
    RIterator<BigInteger> test = new LookAndSayIterator(seed, max);
    test.next();
    test.next();
    assertEquals(false, test.hasNext());
  }

  @Test
  public void testHasPrevTrue() {
    BigInteger seed = new BigInteger("1234");
    BigInteger max = new BigInteger("100000000000");
    RIterator<BigInteger> test = new LookAndSayIterator(seed, max);
    test.next();
    test.next();
    assertEquals(true, test.hasPrevious());
  }

  @Test
  public void testHasPrevFalse() {
    BigInteger seed = new BigInteger("123");
    BigInteger max = new BigInteger("100000000000");
    RIterator<BigInteger> test = new LookAndSayIterator(seed, max);

    assertEquals(false, test.hasPrevious());
  }

}
