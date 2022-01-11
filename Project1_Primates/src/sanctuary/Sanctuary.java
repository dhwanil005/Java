package sanctuary;

import java.util.ArrayList;

/** 
 * Class for Sanctuary.
 */
public class Sanctuary {
  private int numberOfMonkey;
  private int numberOfTroops;
  private Monkey monkey;
  private ArrayList<Monkey> monki;
  
  
  enum FavouriteFood {
    eggs, fruits, insects, leaves, nuts, seeds, treeSap
  }
  
  enum Size {
    Small, Medium, Large
  }
  
  enum Sex {
    Male, Female
  }
  
  /**
   * Constructor to initialize variables.
   */
  public Sanctuary(int numberOfMonkey, int numberOfTroops) {
    this.numberOfMonkey = numberOfMonkey;
    this.numberOfTroops = numberOfTroops;
    monki = new ArrayList<Monkey>();
    
  }
  
  /**
   * Returning the Total Number of Monkeys In Sanctuary.
   */
  public String monkeysInSanctuary() {
    String x  = "Total Number Of Monkeys in the Sanctuary is:" + this.numberOfMonkey;
    return x;
  }
  
  /**
   *Returning the Total Number of Troops In Sanctuary. 
   */
  public String totalTroops() {
    String y = "Total Number Of Monkeys in the Sanctuary is:" + this.numberOfTroops;
    return y;
  }
  /**
   * Locating A Monkey..
   */
  
  public String locateMonkey(String name) {
    String g = "Monkey named" + monkey.getName() + "is currently in:" + monkey.getHousingType();
    return g;
  }
  
  /**
   * Adding Monkey.
   */
  
  public void  addMonkey(Monkey m1) {
    monki.add(m1);
  }
  /**
   *ArrayList for Printing List.
   */
   
  public ArrayList<Monkey> printListSanctuary() {
    return this.monki;
  }
  
  
  
}

