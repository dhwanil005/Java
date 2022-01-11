package lookandsay;

import java.math.BigInteger;
import java.util.NoSuchElementException;

/**
 * LookAndSayIterator class has methods that will help in computing the
 * lookandsay sequence.
 */
public class LookAndSayIterator implements RIterator<BigInteger> {
  private BigInteger value;
  private BigInteger end;
  private int seed;
  private boolean hasNext;
  private static final BigInteger maxDefault = new BigInteger("9".repeat(100));
  private static final BigInteger seedDefault = new BigInteger("1");

  /**
   * Constructor for initializing with both variables of our choice.
   * 
   * @param seed the number at which the sequence must begin.
   * @param end  the maximum value.
   */
  public LookAndSayIterator(BigInteger seed, BigInteger end) {
    validateSeed(seed, end);
    value = seed;
    this.end = end;
    hasNext = false;
  }

  /**
   * constructor for initializing with only seed.
   * 
   * @param seed the number at which the sequence must begin.
   */
  public LookAndSayIterator(BigInteger seed) {
    this(seed, maxDefault);
  }

  /**
   * Default Constructor for using default values mentioned above.
   */
  public LookAndSayIterator() {
    this(seedDefault, maxDefault);
  }

  /**
   * Checking if the seed is greater than max or It contains any zero or if it is
   * negative.
   * 
   * @param seed the number at which the sequence must begin.
   * @param end  the maximum value.
   */
  private void validateSeed(BigInteger seed, BigInteger end) {
    if (seed.compareTo(end) >= 0 || seed.compareTo(new BigInteger("0")) <= 0
        || seed.toString().indexOf('0') != -1) {
      throw new IllegalArgumentException("The seed is not valid" + seed.toString());
    }
  }

  @Override
  public boolean hasNext() {
    if (!hasNext) {
      return true;
    }
    return calculateNext(value).compareTo(end) < 0;
  }

  /**
   * Helper method for calculating the next item in sequence.
   * 
   * @param seedValue the seed that is passed.
   * @return the next BigInteger in the sequence.
   */
  public BigInteger calculateNext(BigInteger seedValue) {
    String sv = seedValue.toString();
    String next = "";
    for (int i = 0; i < sv.length();) {
      char digit = sv.charAt(i);
      int count = 1;
      while (i + count < sv.length() && sv.charAt(i + count) == digit) {
        count++;
      }
      next = next + count + digit;
      i = i + count;
    }
    return new BigInteger(next);
  }

  @Override
  public BigInteger next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    if (hasNext) {
      value = calculateNext(value);
    } else {
      hasNext = true;
    }
    return value;
  }

  /**
   * Helper method for computing the previous element.
   * 
   * @param seedValue the seed.
   * @return the BigInteger that is previous.
   */
  public BigInteger calculatePrevious(BigInteger seedValue) {
    String svString = seedValue.toString();
    StringBuilder prev = new StringBuilder();

    for (int i = 0; i < svString.length(); i += 2) {
      int x = Character.digit(svString.charAt(i), 10);
      int y = Character.digit(svString.charAt(i + 1), 10);
      prev.append(String.valueOf(y).repeat(Math.max(0, x)));
    }
    return new BigInteger(prev.toString());

  }

  @Override
  public BigInteger previous() throws NoSuchElementException {
    if (!hasPrevious()) {
      throw new NoSuchElementException("No previous element");
    }
    value = calculatePrevious(value);
    return value;
  }

  @Override
  public boolean hasPrevious() {
    if (value.equals(seedDefault)) {
      return false;
    }
    try {
      return calculatePrevious(value).compareTo(end) < 0;
    } catch (StringIndexOutOfBoundsException e) {
      return false;
    }
  }

}
