package dungeon;

import dungeon.Model;

/**
 * Controller interface for our dungeon game.
 */
public interface DungeonControllerIntf {
  /**
   * Method to help in executing the Dungeon game.
   * 
   * @param g the model.
   * @return true if the game ends.
   */
  boolean playGame(Model g);

  /**
   * Method to help us in executing the dungeon game.
   * 
   * @return true if the game ends.
   */
  boolean playGame();

  /**
   * method to help us in determining which exact cell in the grid has been
   * clicked.
   * 
   * @param rows    the row of the click.
   * @param columns the column of the click.
   */
  void handleCellClick(int rows, int columns);

  /**
   * Restarting the whole game.
   * 
   * @param rows                         rows for our dungeon.
   * @param columns                      columns for our dungeon.
   * @param treasureAndArrowAvailability percentage of caves that will have
   *                                     treasure and arrows.
   * @param interConnectivity            the interconnectivity.
   * @param wrapOrNot                    whether the dungeon is wrapped or not.
   * @param numberOfMonsters             total number of monsters in the dungeon.
   * @param playerName                   the name of our player.
   */
  void gameRestart(int rows, int columns, int treasureAndArrowAvailability, int interConnectivity,
      boolean wrapOrNot, int numberOfMonsters, String playerName);

  /**
   * Reseting the game with the entered values.
   */
  void resetGame();

  /**
   * Method to help us quit the game.
   */
  void quit();
}
