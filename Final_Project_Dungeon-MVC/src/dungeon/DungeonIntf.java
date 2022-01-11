package dungeon;

import java.util.ArrayList;
import java.util.Map;

/**
 * INterface for our class Dungeon.
 * 
 */
public interface DungeonIntf {
  /**
   * Checking whether the player has completed the game or not.
   */
  public void completedDungeon();

  /**
   * Getter method for our rows.
   * 
   * @return the number of rows.
   */
  public int getRows();

  /**
   * Getter Method for start node.
   * 
   * @return start node.
   */
  public int getStartNode();

  /**
   * Getter method for end node.
   * 
   * @return end node.
   */
  public int getEndNode();

  /**
   * Getter method for number of monsters present in the dungeon.
   * 
   * @return number of monsters.
   */
  public int getNumOfMonsters();

  /**
   * Method for getting the game status.
   * 
   * @return true or false based on whether the player has reached the endpoint or
   *         not.
   */
  public boolean getGameStatus();

  /**
   * Getter for columns.
   * 
   * @return the number of columns.
   */
  public int getColumns();

  /**
   * Getter method for interconnectivity.
   * 
   * @return the degree of interconnectivity.
   */
  public int getInterConnectivity();

  /**
   * getter method for treasureAVailability.
   * 
   * @return the percentage of caves that have treasure.
   */
  public int getTreasureAndArrowAvailability();

  /**
   * Getter method for HashMap for monsters.
   * 
   * @return HashMap with caves as key and Object of monster as value.
   */
  public Map<Integer, MonsterIntf> getMonsterMap();

  /**
   * getter for player object.
   * 
   * @param p player object.
   * @return player object.
   */
  public Player getPlayer(Player p);

  /**
   * entering the player in dungeon.
   * 
   * @param p object for Player class.
   */
  public void enterDungeon(Player p);

  /**
   * Gives us the possible moves that player can make in the dungeon.
   * 
   * @param node Total number of nodes in the dungeon.
   * @return arraylist of directions.
   */
  public ArrayList<String> possibleMoves(int node);

  /**
   * finds a random number for starting point.
   * 
   * @return a random number between 1 to 5.
   */
  public int startPoint();

  /**
   * finds a random end point of the dungeon game.
   * 
   * @return a random number between the size of the mst arraylist -10(So that we
   *         can be sure that the minimum path is more than 5.
   */
  public int endPoint();

  /**
   * GEtter method for the total number of caves in the dungeon.
   * 
   * @return An ArrayList.
   */
  public ArrayList<Edge> getMstR();

  /**
   * Method for allocating Monsters in our Dungeon.
   */
  void monsterAllocation();
}
