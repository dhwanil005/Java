package dungeon;

import java.io.IOException;

/**
 * Interface for controller to implement the smooth functioning of controller.
 */

public interface ControllerIntf {
  /**
   * Method for helping scan the next element if there is any.
   * 
   * @return String null
   */
  public String scanHelper();

  /**
   * This method is called when the player inputs p.
   * 
   * @return null and string
   * @throws IllegalStateException we try to invoke it at inappropriate times
   * @throws Exception             general exception
   */
  public String pickup() throws IllegalStateException, Exception;

  /**
   * This method is called when the player inputs m.
   * 
   * @return null and string
   * @throws IllegalStateException we try to invoke it at inappropriate times
   * @throws Exception             general exception
   */
  public String move() throws IllegalStateException, Exception;

  /**
   * This is called in playGame for continuing the game.
   * 
   * @return null
   * @throws IllegalStateException we try to invoke it at inappropriate times
   * @throws Exception             general exception
   */
  public String continueGame() throws IllegalStateException, Exception;

  /**
   * This method helps to bind msp to move pickup and shoot.
   * 
   * @return null and string.
   * @throws IllegalStateException we try to invoke it at inappropriate times
   * @throws IOException           when input output fails or interrupted.
   * @throws Exception             general exception
   */
  public String choiceSelection() throws IllegalStateException, IOException, Exception;

  /**
   * This is the main method for our controller which manipulates other methods to
   * make the woeking of our coontroller seemless.
   * 
   * @throws IOException when input output fails or interrupted.
   */
  public void playGame() throws IOException;

  /**
   * MEthod that helps facilitate shooting in our controller.
   * 
   * @return null.
   * @throws IllegalArgumentException invalid input
   * @throws Exception                general Exception.
   */
  public String shoot() throws IllegalArgumentException, Exception;
}
