package dungeon;

import dungeon.Dungeon.Directions;

/**
 * GUI Controller class.
 *
 */
public class GUIController implements DungeonControllerIntf {
  private Model model;
  private DungeonViewIntf view;
  private KeyBoardController keyListener;

  /**
   * Constructor for GUI Controller.
   * 
   * @param model object of dungeon model.
   * @param view  object of dungeon view.
   */
  public GUIController(Model model, DungeonViewIntf view) {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Model and View should not be null");
    }
    this.model = model;
    this.view = view;
    this.keyListener = new KeyBoardController(this.model);
  }

  @Override
  public boolean playGame() {
    return this.playGame(this.model);
  }

  @Override
  public boolean playGame(Model g) {
    if (g == null) {
      throw new IllegalArgumentException("Game should not be null");
    }
    this.model = g;

    this.view.makeVisible();
    this.view.addClickListener(this, this.keyListener);
    return true;
  }

  @Override
  public void handleCellClick(int rows, int columns) {

    if (!this.model.isGameOver()) {
      int clickedNode = getCave(rows, columns);
      System.out.println(clickedNode);
      if (clickedNode > 0) {
        Directions dir = possibleDir(clickedNode);
        if (dir != null) {

          move(dir);
          this.view.refresh();
        }
      }
    } else {
      this.view.removeClickListener();
    }

  }

  private int getCave(int rows, int columns) {
    int r = 1;
    for (int i = 1; i <= this.model.getDungeonRows(); i++) {
      for (int j = 1; j <= this.model.getDungeonColumns(); j++) {
        if (i == rows && j == columns) {
          return r;
        }
        r += 1;
      }
    }
    return -1;
  }

  private void move(Directions dir) {
    try {
      if (dir == null) {
        return;
      }
      this.model.movePlayer(dir);
      if (!this.model.isPlayerAlive()) {
        return;
      }
      if (this.model.getPlayersCurrentLocation() == this.model.getEndCave()) {
        return;
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  private Directions possibleDir(int clickedNode) {
    int s = this.model.getPlayersCurrentLocation();
    if (s > clickedNode) {
      if (clickedNode == s - 1) {
        return Directions.WEST;
      } else if (clickedNode == s - this.model.getDungeonColumns()) {
        return Directions.NORTH;
      }
    } else if (s < clickedNode) {
      if (clickedNode == s + 1) {
        return Directions.EAST;
      } else if (clickedNode == s + this.model.getDungeonColumns()) {
        return Directions.SOUTH;
      }
    }
    return null;

  }

  @Override
  public void gameRestart(int rows, int columns, int interConnectivity,
      int treasureAndArrowAvailability, boolean wrapOrNot, int numberOfMonsters,
      String playerName) {
    this.model.startGame(rows, columns, interConnectivity, treasureAndArrowAvailability, wrapOrNot,
        numberOfMonsters, playerName);
    
  }

  @Override
  public void resetGame() {
    this.model.reset();

  }

  @Override
  public void quit() {
    System.exit(0);

  }

}
