package polynomial;

/**
 * Class for Polynomials.
 */

public class ListOfPoly implements ListOfPolynomials {
  private NodeIntf head;

  public ListOfPoly() {
    head = new EmptyNode();
  }

  @Override
  public void addPolyFront(Poly p) {
    head = head.addPolyFront(p);

  }

  @Override
  public void addPolyBack(Poly p) {
    head = head.addPolyBack(p);

  }

  @Override
  public void addPolyAt(int index, Poly p) {
    head = head.addPolyAtIndex(index, p);
  }

  @Override
  public void removePoly(Poly p) {
    head = head.removePoly(p);
  }

  @Override
  public int getSizeOfList() {
    return head.count();
  }

  @Override
  public Poly getPolyatIndex(int index) throws IllegalArgumentException {
    if ((index >= 0) && (index < getSizeOfList())) {
      return head.getPolyAt(index);
    } else {
      throw new IllegalArgumentException("Index shuold be valid");
    }
  }

  @Override
  public String toString() {
    return head.toString();
  }

}
