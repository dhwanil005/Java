package tictactoe;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The view for our TicTacToe game.
 */
public class ViewClass extends JFrame implements TicTacToeView {

  private static final long serialVersionUID = 3591737730951731915L;
  private ReadonlyTttModel model;
  private JLabel disp;
  private JLabel statusBar;
  private Painter p1;

  /**
   * Constructor for our View Class of TicTacToe.
   * 
   * @param m the model of TicTacToe.
   */
  public ViewClass(ReadonlyTttModel m) {
    super("TicTacToe");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    statusBar = new JLabel("Game In Progress");
    disp = new JLabel("Player X's Turn");
    setSize(500, 500);
    setLocation(200, 200);
    this.model = m;
    this.p1 = new Painter(m);
    add(this.p1, BorderLayout.CENTER);
    add(disp, BorderLayout.NORTH);
    add(statusBar, BorderLayout.SOUTH);
    pack();
  }

  @Override
  public void addClickListener(TicTacToeController listener) {
    this.p1.addMouseListener(new ListenerHelper(listener));

  }

  @Override
  public void refresh() {
    this.p1.removeAll();
    this.p1.revalidate();
    this.p1.repaint();
    this.disp.setText(this.model.getTurn().name().toUpperCase() + "'s Turn");

    if (this.model.isGameOver()) {
      Player w = this.model.getWinner();
      if (w != null) {
        this.statusBar.setText(w.name().toUpperCase() + "WINS!");
      } else {
        this.statusBar.setText("Tie");
      }
    }
  }

  @Override
  public void makeVisible() {
    setVisible(true);

  }

}
