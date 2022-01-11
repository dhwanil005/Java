package dungeon;

import dungeon.Dungeon.Directions;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;

/**
 * DungeonConsoleController is the controller for our dungeon game(mvc).
 */

public class DungeonConsoleController implements ControllerIntf {
  private Dungeon d11;
  private Player p11;

  private final Appendable out;
  private final Scanner scan;

  private Treasure t1 = new Treasure();
  private Arrows a1 = new Arrows();
  private Monster m1 = new Monster();

  private Map<String, Callable<String>> inputController;

  /**
   * Constructor to initialize values.
   * 
   * @param rows                 number of rows.
   * @param columns              number of columns.
   * @param interconnectivity    degree of interconnectivity.
   * @param wrapOrNot            whether the dungeon is wrapping or non wrapping.
   * @param treasuerAvailability percentage of treasure and arrow availability.
   * @param numberOfMonsters     total number of monsters in the dungeon.
   * @param playerName           player name.
   */

  public DungeonConsoleController(int rows, int columns, int interconnectivity, boolean wrapOrNot,
      int treasuerAvailability, int numberOfMonsters, String playerName, Readable in,
      Appendable out) {
    int minTreasureAvailability = 0;

    if (in == null) {
      throw new IllegalArgumentException("Readble should not be null");

    }
    if (out == null) {
      throw new IllegalArgumentException("Appendable should not be null");
    }
    if (treasuerAvailability < minTreasureAvailability) {
      throw new IllegalArgumentException(
          "Availability cannot be less than" + minTreasureAvailability);

    }
    int minInterconnectivity = 0;
    int minColumns = 5;
    int minRows = 5;

    if (interconnectivity < minInterconnectivity) {
      throw new IllegalArgumentException(
          "Degree of InterConnectivity cannot be less than " + minInterconnectivity);

    }

    if (columns < minColumns) {
      throw new IllegalArgumentException("Columns cannot be less than " + minColumns);
    }
    if (rows < minRows) {
      throw new IllegalArgumentException("Rows cannot be less than " + minRows);
    }
    if (playerName.length() < 0) {
      throw new IllegalArgumentException("The length of player's name should be more than 0");
    }
    this.d11 = new Dungeon(rows, columns, interconnectivity, treasuerAvailability, wrapOrNot,
        numberOfMonsters);
    this.p11 = new Player(playerName);

    d11.startPoint();
    d11.endPoint();
    d11.enterDungeon(p11);
    p11.currentPosition(d11);
    t1.treasureAllocation(treasuerAvailability, d11);
    d11.monsterAllocation();
    m1.smellOfMonster(1, d11);

    if (in == null || out == null) {
      throw new IllegalArgumentException("Null values cannot be accepted");
    }
    this.out = out;
    scan = new Scanner(in);

    this.inputController = new HashMap<>();
    this.inputController.put("m", this::move);
    this.inputController.put("p", this::pickup);
    this.inputController.put("s", this::shoot);
  }

  @Override
  public String scanHelper() {
    if (scan.hasNext()) {
      return scan.next();
    }
    return null;
  }

  @Override
  public void playGame() {

    while (d11.getGameStatus()) {
      try {
        out.append(String.valueOf(d11.getEndNode()));
      } catch (IOException e1) {

        e1.printStackTrace();
      }

      continueGame();
      choiceSelection();
    }
  }

  @Override
  public String choiceSelection() {

    try {
      String input = "";
      out.append("Move,Pickup or Shoot? \n");
      input = scanHelper();
      if (!input.equals("q")) {
        try {
          input = (String) this.inputController.get(input).call();
        } catch (Exception e) {

          e.printStackTrace();
        }
      }
      return input;

    } catch (IOException e) {
      throw new IllegalStateException("Append failed", e);
    }
  }

  @Override
  public String continueGame() {
    try {

      if (p11.getAlive() && d11.getGameStatus()) {
        d11.completedDungeon();
        out.append("You Are In  Cave " + p11.getCurrentPosition() + " \n");
        out.append("Possible Directions Are:" + d11.possibleMoves(p11.getCurrentPosition()));
        out.append("\n");

        out.append("This Cave Contains: " + t1.getTreasureMap().get(p11.getCurrentPosition()));
        out.append("\n");

        out.append("This Cave Contains: " + a1.getArrowMap().get(p11.getCurrentPosition()));
        out.append("\n");

        if (m1.smellOfMonster(p11.getCurrentPosition(), d11) == 1) {
          out.append("You smell some strange smell");
          out.append("\n");
        } else if (m1.smellOfMonster(p11.getCurrentPosition(), d11) == 2) {
          out.append("You smell a really intense pungent smell");
          out.append("\n");
        } else {
          out.append("You dont smell any weird smell");
          out.append("\n");
        }

        try {
          choiceSelection();

        } catch (IllegalArgumentException e) {
          out.append(e.getMessage());

        } catch (IllegalStateException e) {
          // ignore
          e.printStackTrace();
        } catch (Exception e) {
          e.printStackTrace();
        }
      } else {
        if (!p11.getAlive()) {
          out.append("You Are Dead");
          d11.gameStatus = false;

        } else if (!d11.getGameStatus()) {
          out.append("YOU WIN");

        }
      }
    } catch (

    IOException e) {
      throw new IllegalStateException("Append failed", e);
    }
    return null;
  }

  @Override
  public String move() {

    try {

      if (!d11.getGameStatus()) {
        out.append("You have succesfully completed the Dungeon And won the game");
      }
      out.append("Which Direction do you want to move in?");
      String dir = scanHelper();
      Directions dir1 = null;
      if (dir.equals("South")) {
        dir1 = Directions.SOUTH;
      } else if (dir.equals("North")) {
        dir1 = Directions.NORTH;
      } else if (dir.equals("East")) {
        dir1 = Directions.EAST;
      } else if (dir.equals("West")) {
        dir1 = Directions.WEST;
      }
      p11.move(dir1, d11);
      continueGame();

    } catch (IllegalArgumentException e) {
      try {
        out.append(e.getMessage());
      } catch (IOException e1) {
        e1.printStackTrace();
      }
      this.move();
    } catch (IOException e) {

      e.printStackTrace();
    }
    return null;

  }

  @Override
  public String pickup() {
    try {
      p11.pickUpTreasure(p11.getCurrentPosition(), t1);
      p11.pickupArrow(p11.getCurrentPosition(), a1);
      out.append("You now have:" + p11.pickedUpItems);
      continueGame();
    } catch (

    IOException e) {
      throw new IllegalStateException("Append failed", e);
    }
    return null;
  }

  @Override
  public String shoot() {
    try {
      m1.getMonLocation(p11.getCurrentPosition(), d11);
      out.append(m1.getMonsterLocation());
      out.append("Which Direction?");
      String dir = scanHelper();
      out.append("How far?");
      int dist = scan.nextInt();
      p11.attackMonster(p11.getCurrentPosition(), dir, dist, d11, m1);
      if (!p11.gethitOrNot()) {
        out.append("You hear a wailing sound from the darkness");
      }
      if (p11.gethitOrNot()) {

        out.append("Arrow Missed");
      }
      continueGame();
    } catch (

    IOException e) {
      throw new IllegalStateException("Append failed", e);
    }
    return null;
  }
}