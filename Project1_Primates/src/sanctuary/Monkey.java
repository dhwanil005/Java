package sanctuary;



/**
 * Class for Monkey's details..
 *
 */

public class Monkey {
  private String name;
  private String speciesDesignation;
  private String sex;
  private String favFood;
  private int approxAge;
  private String size;
  private int id;
  private String housingType;
  
  /**
   * Constructor to initialize variables.
   */
  
  public Monkey(String name, String speciesDesignation, String sex, 
      String favFood, int approxAge, String size, int id, String housingType) {
    this.name = name;
    this.speciesDesignation = speciesDesignation;
    this.sex = sex;
    this.favFood = favFood;
    this.approxAge = approxAge;
    this.size = size;
    this.id = id;
    this.housingType = housingType;
    
    
  } 
  /**
   * Printing Details.
   */
  
  public String getDetails() {
    String s = ("Name: " + this.name + "  " + "Species: " + speciesDesignation 
        + "  "  + "Sex: " + this.sex + "  " 
        + "Favourite Food:" +  this.favFood + "  " + "Approx Age: " + this.approxAge + "  " 
        + "Size: " + this.size + "  " + "ID:" + this.id + "  " + "Housing Type:"
        + this.housingType + "  ");
    return s;
  }
  
  /**
   * Monkey Name.
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * Housing Type.
   */
  public String getHousingType() {
    return this.housingType;
  }
  
  /**
   * Favorite Food.
   */
  public String getFavFood() {
    return this.favFood;
  }
  
  /**
   * Size.
   */
  public String getSize() {
    return this.size;
  }
  
  /**
   * sex.
   */
  public String getSex() {
    return this.sex;
  }
 
}


