package tictactoe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Listener class for any clicks on the tictactoe grid.
 */

public class ListenerHelper extends MouseAdapter {
  private TicTacToeController listener;

  /**
   * Constructor for our listener class.
   * 
   * @param listener controller of tictactoe.
   */
  public ListenerHelper(TicTacToeController listener) {
    if (listener == null) {
      throw new IllegalArgumentException("Prohibited listener:NULL");
    }
    this.listener = listener;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();

    int xCoordinate = Math.round(x / 60) - 1;
    int yCoordinate = Math.round(y / 60) - 1;

    try {
      if (xCoordinate < 3 && yCoordinate < 3) {
        listener.handleCellClick(xCoordinate, yCoordinate);
      }
    } catch (IllegalArgumentException e1) {
      // Ignore this because the user has clicked somewhere other than the legal
      // position so we ignore it and continue.
    }

  }
}
