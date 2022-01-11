package sanctuary;

/**
 * Class for housing named Isolation.
 *
 */

public class Isolation {
  private int currentCellNumber;
  private int totalNumberOfCells;
  private boolean medicalAssesment;
 
  /**
   * Constructor for initializing Variables. 
   */
  public Isolation(int currentCellNumber, int totalNumberOfCells, 
       boolean medicalAssesment) {
    this.currentCellNumber = currentCellNumber;
    this.totalNumberOfCells = totalNumberOfCells;
    this.medicalAssesment = medicalAssesment;
  }
  /**
   * total number of cells.
   */
  
  public int numberOfCells() {
    return this.totalNumberOfCells;
  }
  /**
   *Checking Availability.
   */

  public String availablity(int totalNumberOfCells) {
    if (currentCellNumber <= totalNumberOfCells) {
      String a = "Cells Available";
      return a;
    } else {
      String b = "No cells Available";
      return b;
    }
  }
  
  /**
   * Checking if the monkey is healthy or not.
   */
  
  public String isHealthy(int currentCellNumber) {
    if (medicalAssesment) {
      String c = "Monkey Is Medically Assesed and is now Healthy";
      return c;
    } else {
      String d = "Monkey is Medically Assesed but is not "
          + "Healthy and still needs to be in Isolation for a longer time";
      return d;
    }
  }
}
