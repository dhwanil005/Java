package dungeon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class Helping to listen to any clicks that happen on out grid(dungeon).
 */
public class ClickHelper extends MouseAdapter {

  private DungeonControllerIntf listener;

  /**
   * Constructor for ClickHelper.
   * 
   * @param listener controller of dungeon.
   */
  public ClickHelper(DungeonControllerIntf listener) {
    if (listener == null) {
      throw new IllegalArgumentException("Listener Cannot be null.");
    }
    this.listener = listener;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    int xcoord = e.getX();
    int ycoord = e.getY();

    int xcoordinate = Math.round(xcoord / 50) + 1;
    int ycoordinate = Math.round(ycoord / 50);
    try {
      listener.handleCellClick(ycoordinate, xcoordinate);
    } catch (IllegalArgumentException e1) {
      // user clicked somewhere other than the grid so we ignore this click and let
      // the user continue.
    }
  }
}
