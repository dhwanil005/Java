package dungeon;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * driver class to run our program.
 */
public class Driver {
  /**
   * Main method.
   * 
   */
  public static void main(String[] args) {
    int treasureAvailability = args.length > 0 ? Integer.parseInt(args[0]) : 20;
    int interConnectivity = args.length > 0 ? Integer.parseInt(args[1]) : 2;
    int numberOfMonster = args.length > 0 ? Integer.parseInt(args[2]) : 1;
    int rows = args.length > 0 ? Integer.parseInt(args[3]) : 6;
    int columns = args.length > 0 ? Integer.parseInt(args[4]) : 8;
    boolean wrapOrNot = args.length > 0 ? Boolean.parseBoolean(args[5]) : false;
    int run = args.length > 0 ? Integer.parseInt(args[6]) : 2;
    String playerName = "d";
    Readable input = new InputStreamReader(System.in);
    Appendable output = System.out;
    Model model = new Game(rows, columns, interConnectivity, treasureAvailability, wrapOrNot,
        numberOfMonster, playerName);
    DungeonViewIntf view = new DungeonViewClass(model);
    if (run == 1) {
      DungeonControllerIntf controller = new GUIController(model, view);

      controller.playGame(model);
    }
    if (run == 2) { 
      ControllerIntf controller = new DungeonConsoleController(rows, columns, interConnectivity,
          wrapOrNot, treasureAvailability, numberOfMonster, playerName, input, output);
      try {
        controller.playGame();
      } catch (IOException e) {

        e.printStackTrace();
      }
    }
  }
}