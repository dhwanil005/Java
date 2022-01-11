package sanctuary;

import java.util.ArrayList;

/**
 *Class for Enclosure.
 */
public class Enclosure {
  
  private int totalNumberOfEnclosures;
  private int currentEnclosureNumber;
  private ArrayList<Monkey> enclo;

  /**
 * Constructor for initializing variables.
 */
  public Enclosure(boolean roomAvailable, int enclosureNumber, int totalNumberOfEnclosures,
      int currentEnclosureNumber) {
    this.totalNumberOfEnclosures = totalNumberOfEnclosures;
    this.currentEnclosureNumber = currentEnclosureNumber;
    enclo = new ArrayList<Monkey>();
  }
  
  /**
   *Checking if room is available or not.
   */
  public boolean roomAvailable() {
    boolean roomAvailable;
    int enclosureNumber;
    if (this.currentEnclosureNumber <= this.totalNumberOfEnclosures) {
      return true;
    } else {
      return false;
    }
  }
  /**
   * add monkey.
   */
  
  public void  addMonkeyInEnclosure(Monkey e1) {
    enclo.add(e1);
  }
  /**
   * print list. 
   */
  
  public ArrayList<Monkey> printListEnclosure() {
    return this.enclo;
  }  
}
