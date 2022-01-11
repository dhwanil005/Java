package dungeon;


import java.util.Map;

/**
 * Interface for Arrow class which has methods to perform desired operations on
 * arrows.
 */

public interface ArrowIntf {
  /**
   * Method for arrow allocation in our dungeon.
   * 
   * @param treasureAvailability is the percentage of caves that have.
   *                             arrows/treasure.
   * @param d                    Object of class dungeon.
   */
  public void arrowAllocation(int treasureAvailability, Dungeon d);

  /**
   * Getter method of HashMap that has caves and the arrows.
   * 
   * @return A HashMap with caves as key and arrows as values.
   */
  public Map<Integer, String> getArrowMap();

  /**
   * Method for removing arrows from the caves after the player has picked them
   * up.
   * 
   * @param cave the current position of the player.
   */
  public void updateArrows(int cave);
}
