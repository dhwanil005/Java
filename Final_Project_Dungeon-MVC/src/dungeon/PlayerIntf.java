package dungeon;

import java.util.ArrayList;
import java.util.HashMap;
import dungeon.Dungeon.Directions;

/**
 * INterface for our player class.
 * 
 */
public interface PlayerIntf {
  /**
   * We move the player using this method.
   * 
   * @param direction the string is what the user inputs.
   * @param d         object for accessing the number of columns we require to
   *                  move.
   */
  public void move(Directions direction, Dungeon d);

  /**
   * Getter method for name.
   * 
   * @return the name of the player.
   */
  public String getName();

  /**
   * sets the player's currentPosition to the startNode.
   * 
   * @param d for accessing the method startNode.
   */
  public void currentPosition(Dungeon d);

  /**
   * Getter method for currentPosition.
   * 
   * @return the currentPosition of the player.
   */
  public int getCurrentPosition();

  /**
   * Getter method for Player's life or death.
   * 
   * @return true if player is alive false if player is dead.
   */
  public boolean getAlive();

  /**
   * method for updating arrows when player shoots them.
   */
  public void updateArrow();

  /**
   * Method for player to attack monster.
   * 
   * @param cave      the current position of player.
   * @param direction the direction in which the player wants to shoot an arrow.
   * @param distance  the distance at which the player wants to shoot an arrow.
   * @param d         object of class Dungeon.
   * @param m         object of class Monster.
   * 
   */
  public void attackMonster(int cave, String direction, int distance, Dungeon d, Monster m);

  /**
   * Getter method for the boolean hit or not.
   * 
   * @return whether the monster has been hit or not.
   */
  public boolean gethitOrNot();

  /**
   * Method that allows user to pickup treasure. param cave current position of
   * player.
   * 
   * @param t treasure object.
   * @return the pickedup items by user
   */
  public String pickUpTreasure(int cave, Treasure t);

  /**
   * Method that helps player pickup arrows.
   * 
   * @param cave current position of the player.
   * @param a    object of arrow class.
   * @return arrows that the player has picked up
   * 
   */
  public String pickupArrow(int cave, Arrows a);

  /**
   * getter method for picked up items by the user.
   * 
   * @return a HashMap of all the items that are possessed by player.
   */
  public HashMap<String, Integer> getPickedTreasure();

  /**
   * Checking if the player wins or gets eaten alive by otyugh.
   * 
   * @param cave location of the player
   * @param d    object of class dungeon.
   * @param m    object for class monster.
   */
  public void winOrLose(int cave, Dungeon d, Monster m);

  /**
   * Getter method for explored caves.
   * 
   * @return all the caves player has visited.
   */
  ArrayList<Integer> getExploredCaves();
}
