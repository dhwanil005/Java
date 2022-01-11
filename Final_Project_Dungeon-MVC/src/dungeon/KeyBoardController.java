package dungeon;

import dungeon.Dungeon.Directions;

/**
 * Controller class that handles inputs from the keyboard.
 */
public class KeyBoardController {
  private Model model;

  /**
   * Constructor for our keyboard controller class.
   * 
   * @param model the model.
   */

  public KeyBoardController(Model model) {
    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }
    this.model = model;
  }

  /**
   * Method that deals with moving player.
   * 
   * @param dir the desired direction
   */
  public void move(Directions dir) {
    try {
      if (dir == null) {
        return;
      }
      model.movePlayer(dir);
      if (model.isPlayerAlive()) {
        return;
      }
      return;
    } catch (IllegalArgumentException e) {
      // Ignore
    }
    return;
  }

  /**
   * Method that deals with picking stuff up.
   * 
   * @return confirmation that player picked up what they were suppposed to.
   */
  public String pickup() {
    model.pikcupItemsCave();
    System.out.println(model.getplayerDetails());
    return "p";
  }

  /**
   * Method that deals with shooting.
   * 
   * @param dist how far the player wants to shoot.
   * @param dir  the direction that we want to shoot.
   * @return confirmation that arrow has been shot.
   */
  public String shoot(int dist, Directions dir) {
    try {
      this.model.shoot(dir, dist);
    } catch (NumberFormatException e) {
      // ignore.
    }
    return "s";
  }
}
