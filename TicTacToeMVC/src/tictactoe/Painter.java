package tictactoe;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * Implementation of JPanel.
 */
public class Painter extends JPanel {

  private ReadonlyTttModel model;

  /**
   * Constructor for Painter Class.
   * 
   * @param model object of model(readonly).
   */
  public Painter(ReadonlyTttModel model) {
    this.model = model;
    this.setLayout(new GridLayout(3, 3));
    this.setPreferredSize(new Dimension(300, 300));
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
  }

  @Override
  public void paint(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    for (int i = 1; i <= 3; i++) {
      for (int j = 1; j <= 3; j++) {
        int c = i * 60;
        int d = j * 60;
        int a = 60;
        int b = 60;
        String s = "";

        if (this.model.getMarkAt(i - 1, j - 1) != null) {
          s = this.model.getMarkAt(i - 1, j - 1).toString();
        }
        new GridView(c, d, a, b, s).draw(g2d);
      }
    }

  }
}
