package polynomial;

/**
 * INterface for element node and empty node, we can perform certain operations
 * on polynomials.
 * 
 */
public interface NodeIntf {
  /**
   * Returns the number of polynomials in the list that is the size of the list.
   */
  int count();

  /**
   * Adding polynomial to the front of the list.
   * 
   * @param p the polynomial we want to add
   */
  NodeIntf addPolyFront(Poly p);

  /**
   * Adding polynomial to the back of the list.
   * 
   * @param p the polynomial we want to add.
   */
  NodeIntf addPolyBack(Poly p);

  /**
   * adding the polynomial at a specified index.
   * 
   * @param index at what index we want to add the polynomial.
   * 
   * @param p     the polynomial we want to add.
   */

  NodeIntf addPolyAtIndex(int index, Poly p);

  /**
   * Removes the polynomial mentioned.
   * 
   * @param p polynomial that we want to remove.
   */
  NodeIntf removePoly(Poly p);

  /**
   * returns the polynomial at the specified index.
   * 
   * @param index of the polynomial.
   */

  Poly getPolyAt(int index);

}
