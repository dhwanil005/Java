package dungeon;

import dungeon.Dungeon.Directions;

/**
 * Model interface for our mvc structure.
 */
public interface Model extends ReadOnlyDungeonIntf {
  /**
   * Method to help player move.
   * 
   * @param direction the direction in which the player will move.
   * @return Current position and options to where the player can move.
   */
  public String movePlayer(Directions direction);

  /**
   * Method to pickup items that are in the cave.
   * 
   * @return all the items picked up.
   */
  public String pikcupItemsCave();

  /**
   * Method to help player shoot the monsters.
   * 
   * @param dir      Direction that the player wants to shoot.
   * @param distance the distance at which the arrow has to be shot.
   * @return updated arrows.
   */
  public String shoot(Directions dir, int distance);

  /**
   * Starting our Dungeon game.
   * 
   * @param rows                         rows.
   * @param columns                      columns.
   * @param interConnectivity            interConnectivity.
   * @param treasureAndArrowAvailability percentage of caves that have treasure
   *                                     and arrow.
   * @param wrapOrNot                    dungeon wrap or not.
   * @param numberOfMonsters             total number of monsters in dungeon.
   * @param playerName                   name of our player.
   */
  public void startGame(int rows, int columns, int interConnectivity,
      int treasureAndArrowAvailability, boolean wrapOrNot, int numberOfMonsters, String playerName);

  /**
   * resetting the game with same parameters.
   */
  public void reset();
}
