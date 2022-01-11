package polynomial;

import java.util.ArrayList;

/**
 * Implementation of Polynomial Interface,we perform several functions on
 * polynomials as well as add them into the list in this class.
 */
public class PolynomialImpl implements Polynomial {
  private ListOfPolynomials list;

  public PolynomialImpl() {
    this.list = new ListOfPoly();
  }

  /**
   * Constructor for parsing the polynomial.
   * 
   * @param s polynomial we want to parse.
   */

  public PolynomialImpl(String s) {
    this.list = new ListOfPoly();
    int coeff = 0;
    int power = 0;
    String[] arr = s.split(" ");

    ArrayList<String[]> parts = new ArrayList<String[]>();
    for (int x = 0; x < arr.length; x++) {
      if (!arr[x].contains("x^")) {
        arr[x] = arr[x] + "x^0";
      }
    }
    for (int i = 0; i < arr.length; i++) {
      parts.add(arr[i].split("x\\^"));
    }
    for (int i = 0; i < parts.size(); i++) {
      String[] x = parts.get(i);
      for (int j = 0; j < x.length - 1; j++) {

        coeff = Integer.parseInt(x[j]);
        power = Integer.parseInt(x[j + 1]);
        this.addTerm(coeff, power);

      }
    }
  }

  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {

    Polynomial addition = new PolynomialImpl();
    if (!(other instanceof PolynomialImpl)) {
      throw new IllegalArgumentException("Other should be an instance of PolynomailImpl");
    }

    for (int i = 0; i < this.list.getSizeOfList(); i++) {
      addition.addTerm(this.list.getPolyatIndex(i).getCoefficient(),
          this.list.getPolyatIndex(i).getPower());
    }

    for (int i = 0; i < ((PolynomialImpl) other).getList().getSizeOfList(); i++) {
      Poly polyNow = ((PolynomialImpl) other).getList().getPolyatIndex(i);
      addition.addTerm(polyNow.getCoefficient(), polyNow.getPower());

    }
    return addition;
  }

  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    boolean flag = false;
    if (power < 0) {
      throw new IllegalArgumentException("Power should always be positive");
    }

    for (int i = 0; i < this.list.getSizeOfList(); i++) {
      if (this.list.getPolyatIndex(i).getPower() == power) {
        int coeffNow = this.list.getPolyatIndex(i).getCoefficient();

        this.list.removePoly(this.list.getPolyatIndex(i));
        if (coeffNow + coefficient != 0) {
          int coeffUpdated = coeffNow + coefficient;
          this.list.addPolyBack(new Poly(coeffUpdated, power));
          flag = true;
          break;
        }

        flag = true;
      }
    }

    if (!flag) {
      this.list.addPolyBack(new Poly(coefficient, power));
    }

  }

  @Override
  public boolean isSame(Polynomial poly) {

    return (this.toString().equals(poly.toString()));

  }

  @Override
  public double evaluate(double x) {
    double evalPoly = 0;
    for (int i = 0; i < this.list.getSizeOfList(); i++) {
      evalPoly = evalPoly + this.list.getPolyatIndex(i).evaluatePoly(x);
    }

    return evalPoly;
  }

  @Override
  public int getCoefficient(int power) {
    for (int i = 0; i < this.list.getSizeOfList(); i++) {
      if (power == this.list.getPolyatIndex(i).getPower()) {
        return this.list.getPolyatIndex(i).getCoefficient();
      }
    }

    return 0;
  }

  @Override
  public int getDegree() {
    int maxDegree = 1;
    for (int i = 0; i < this.list.getSizeOfList(); i++) {
      if (maxDegree < this.list.getPolyatIndex(i).getPower()) {
        maxDegree = this.list.getPolyatIndex(i).getPower();
      }
    }

    return maxDegree;
  }

  public ListOfPolynomials getList() {
    return this.list;

  }

  /**
   * To string method to print.
   */
  public String toString() {
    String p = "";
    for (int i = 0; i < this.list.getSizeOfList(); i++) {
      p = p + this.list.getPolyatIndex(i).toString() + " ";
    }
    return p;
  }

}
