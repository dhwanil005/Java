
package dungeon;

import java.util.ArrayList;


/**
 * ReadOnly Model Interface for our Dungeon Game.
 */
public interface ReadOnlyDungeonIntf {
  /**
   * Getter method for Rows.
   * 
   * @return rows.
   */
  public int getDungeonRows();

  /**
   * Getter method for Columns.
   * 
   * @return columns
   */
  public int getDungeonColumns();

  /**
   * Getter method for Percentage.
   * 
   * @return percentage.
   */
  public int getDungeonTreasureAndArrowAvailability();

  /**
   * Getter method for Number of monsters.
   * 
   * @return number of monsters.
   */
  public int getDungeonNumberOfMonsters();

  /**
   * Getter method for wrapOrNot.
   * 
   * @return if the dungeon is wrapping or not
   */
  public boolean getDungeonWrapOrNot();

  /**
   * Getter method for interconnectivity.
   * 
   * @return interconnectivity.
   */
  public int getDungeonInterConnectivity();

  /**
   * Getter method for name.
   * 
   * @return players name.
   */
  public String getPlayerName();

  /**
   * Getter method for players picked up details.
   * 
   * @return players picked up items.
   */
  public String getAllPlayersPickUpDetails();

  /**
   * Getter method to check if the player is alive.
   * 
   * @return true if player alive, fale if dead.
   */
  public boolean isPlayerAlive();

  /**
   * Get all player stats.
   * 
   * @return stats of player.
   */
  public String getplayerDetails();

  /**
   * getter method for game being over.
   * 
   * @return true if game over, false if in progress.
   */
  public boolean isGameOver();

  /**
   * Getting players current location.
   * 
   * @return location of player.
   */
  public int getPlayersCurrentLocation();

  /**
   * displaying available arrows.
   * 
   * @param cave current location.
   * @return available arrows at particular location.
   */
  public String displayAvailableArrow(int cave);

  /**
   * displaying available Treasure.
   * 
   * @param cave current location.
   * @return available treasure at particular location.
   */
  public String displayAvailableTreasure(int cave);

  /**
   * Checking for any present monsters around player.
   * 
   * @param cave current location.
   * @return smell level.
   */
  public String displaySmell(int cave);

  /**
   * Getting end point.
   * 
   * @return end cave of dungeon.
   */
  public int getEndCave();

  /**
   * Get all the caves that player has visited.
   * 
   * @return all caves player explored.
   */
  public ArrayList<Integer> getAllCavesExplored();

}
