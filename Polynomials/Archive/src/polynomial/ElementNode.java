package polynomial;

/**
 * This class represents an element node in the list adt implementation.
 */
public class ElementNode implements NodeIntf {
  private Poly p1;
  private NodeIntf rest;

  public ElementNode(Poly p1, NodeIntf rest) {
    this.p1 = p1;
    this.rest = rest;
  }

  @Override
  public int count() {
    return 1 + this.rest.count();
  }

  @Override
  public NodeIntf addPolyFront(Poly p1) {
    return new ElementNode(p1, this);
  }

  @Override
  public NodeIntf addPolyBack(Poly p1) {
    this.rest = this.rest.addPolyBack(p1);
    return this;
  }

  @Override
  public NodeIntf addPolyAtIndex(int index, Poly p1) {
    if (index == 0) {
      return addPolyFront(p1);
    } else {
      this.rest = this.rest.addPolyAtIndex(index - 1, p1);
      return this;
    }
  }

  @Override
  public NodeIntf removePoly(Poly p1) {
    if (this.p1.equals(p1)) {
      return this.rest;
    } else {
      this.rest = this.rest.removePoly(p1);
      return this;
    }
  }

  @Override
  public Poly getPolyAt(int index) throws IllegalArgumentException {
    if (index == 0) {
      return this.p1;
    }

    return this.rest.getPolyAt(index - 1);
  }

  @Override
  public String toString() {
    String returnString = this.p1.toString();
    if (this.p1.getCoefficient() > 0) {
      returnString = "+" + returnString;
    }
    return returnString + " " + this.rest.toString();
  }
}