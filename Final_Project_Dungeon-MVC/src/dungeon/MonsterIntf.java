package dungeon;

/**
 * Interface for Monster class with methods that are used to manipulate the
 * monsters allocation and health.
 */

public interface MonsterIntf {
  /**
   * Getter Method for getting health of monster.
   * 
   * @return the health.
   */
  public int getHealth();

  /**
   * Getter MEthod for getting the status of monster that is, whether it is alive
   * or dead.
   * 
   * @return the status of monster.
   */
  public boolean getDeadOrNot();

  /**
   * Method for detecting smell of monster.
   * 
   * @param cave the location at which the player is at now.
   * @param d    the object of class dungeon.
   */
  public int smellOfMonster(int cave, Dungeon d);

  /**
   * Checks if the monster has been hit or not and updates the health accordingly.
   *
   * @return health of monster.
   */
  public int hitByArrow(boolean bool);

  /**
   * Getter method for getting the monsters location in context to the player.
   * 
   * @return direction in which monster is there from player.
   */
  public String getMonsterLocation();

  /**
   * MEthod for updating the caves with monsters after they are dead.
   * 
   * @param cave current position of monster.
   * @param d    object of class.
   */
  public void updateMonster(int cave, Dungeon d);

  /**
   * Method for getting monsters location.
   * 
   * @param cave the current cave.
   * @param d    object of dungeon class.
   * @return the position of the monster.
   */
  public String getMonLocation(int cave, Dungeon d);
}
