package dungeon;

/**
 * Interface for our view class in dungeon.
 * 
 */
public interface DungeonViewIntf {
  /**
   * Method to handle click events.
   * 
   * @param listener the controller of our Dungeon game.
   */
  void addClickListener(DungeonControllerIntf listener, KeyBoardController keyListener);

  /**
   * Refreshing the view every time some new action is done.
   */
  void refresh();

  /**
   * Method to help make view visible.
   */
  void makeVisible();

  /**
   * Remove controller for handling click events in view.
   */
  void removeClickListener();

  /**
   * Shooting helper method.
   */
  void shootingHelper(int point);

}
