package polynomial;

/**
 * Interface for list of polynomials.
 */

public interface ListOfPolynomials {
  /**
   * This method adds a polynomial to the front of the polynomial list.
   * 
   * @param p this is the polynomial that is to be added.
   */
  void addPolyFront(Poly p);

  /**
   * This method adds a polynomial to the back of the polynomial list.
   * 
   * @param p this is the polynomial that is to be added.
   */
  void addPolyBack(Poly p);

  /**
   * This method adds a polynomial to the specified index.
   * 
   * @param index this is the index we want to add our polynomial at.
   * @param p     this is the polynomial we want to add to the list.
   */
  void addPolyAt(int index, Poly p);

  /**
   * Removes the specified polynomial from the list.
   * 
   * @param p this is the polynomial that we want to remove from the list.
   */
  void removePoly(Poly p);

  /**
   * Will return the size of our polynomial list.
   */
  int getSizeOfList();

  /**
   * getPolyatIndex returns the polynomial at the specific index.
   * 
   * @param index specifying the index of the polynomial we want.
   * @return will return the polynomial at the specified index.
   * @throws IllegalArgumentException will throw exception if the input is not
   *                                  valid.
   */
  Poly getPolyatIndex(int index) throws IllegalArgumentException;
}
