package polynomial;

/**
 * monomial class.
 */
public class Poly {
  private int coefficient;
  private int power;

  /**
   * monomial constructor for assigning coefficient and power.
   */
  public Poly(int coefficient, int power) {
    if (power < 0) {
      throw new IllegalArgumentException("Power should be positive only");
    }
    this.coefficient = coefficient;
    this.power = power;

  }

  public int getCoefficient() {
    return this.coefficient;
  }

  public int getPower() {
    return this.power;
  }

  public double evaluatePoly(double var) {
    return this.coefficient * (Math.pow(var, this.power));

  }

  @Override
  public String toString() {
    if (this.power > 0) {
      return this.coefficient + "x^" + this.power;
    } else {
      return "" + this.coefficient;
    }

  }

}
