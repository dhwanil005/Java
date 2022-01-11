package dungeon;


import java.util.Map;

/**
 * Interface for our class treasure.
 */

public interface TreasureIntf {

  /**
   * method allocates treasure to random caves in the dungeon.
   * 
   * @param treasureAvailability the percentage amount of caves to be allocated
   *                             treasure.
   * @param d                    the object of class dungeon.
   */
  public void treasureAllocation(int treasureAvailability, Dungeon d);

  /**
   * Getter method for where our treasure is stored,which caves have treasure and
   * exactly what treasure do they have are displayed.
   * 
   * @return a HashMap that has caves and treasure.
   */
  public Map<Integer, String> getTreasureMap();

  /**
   * Removing treasure from the caves after the player has picked them up.
   * 
   * @param cave the current position of the player.
   */
  public void updateTreasure(int cave);

}
