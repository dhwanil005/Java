package polynomial;

/**
 * Class for empty node.
 */

public class EmptyNode implements NodeIntf {

  @Override
  public int count() {
    return 0;
  }

  @Override
  public NodeIntf addPolyFront(Poly p) {

    return new ElementNode(p, this);
  }

  @Override
  public NodeIntf addPolyBack(Poly p) {

    return addPolyFront(p);
  }

  @Override
  public NodeIntf addPolyAtIndex(int index, Poly p) {
    if (index == 0) {
      return addPolyFront(p);
    }
    throw new IllegalArgumentException("Enter Valid Index");
  }

  @Override
  public NodeIntf removePoly(Poly p) {

    return this;
  }

  @Override
  public Poly getPolyAt(int index) {

    throw new IllegalArgumentException("Invalid INdex");
  }

}
