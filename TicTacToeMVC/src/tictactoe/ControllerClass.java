package tictactoe;

/**
 * The controller class for our tictactoe game.
 */
public class ControllerClass implements TicTacToeController {
  private TicTacToe m;
  private TicTacToeView v;

  /**
   * Constructor for our TicTacToe Controller.
   * 
   * @param m the model for TicTacToe.
   * @param v the view for TicTacToe.
   */
  public ControllerClass(TicTacToe m, TicTacToeView v) {
    if (!(m instanceof TicTacToeModel)) {
      throw new IllegalArgumentException("Incorrect Model");
    }
    if (!(v instanceof ViewClass)) {
      throw new IllegalArgumentException("Incorrect View");
    }
    this.m = m;
    this.v = v;
  }

  @Override
  public void playGame() {
    this.v.makeVisible();
    this.v.addClickListener(this);

  }

  @Override
  public void handleCellClick(int row, int col) {
    if (!this.m.isGameOver() && this.m.getMarkAt(row, col) == null) {
      this.m.move(row, col);
      this.v.refresh();
    }
  }

}
