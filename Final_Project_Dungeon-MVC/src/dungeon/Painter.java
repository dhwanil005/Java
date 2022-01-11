package dungeon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * Class for Implementing JPanel.
 * 
 */
public class Painter extends JPanel {
 
  private static final long serialVersionUID = 1L;
  private ReadOnlyDungeonIntf model;

  /**
   * Constructor for Painter.
   * 
   * @param model read only object.
   */
  public Painter(ReadOnlyDungeonIntf model) {
    this.model = model;
    this.setLayout(new GridLayout(4, 3));
    this.setPreferredSize(new Dimension(400, 400));

  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
  }

  @Override
  public void paint(Graphics g) {
    super.paintComponent(g);
    Graphics2D g3 = (Graphics2D) g;
    int locationPlayer = this.model.getPlayersCurrentLocation();
    int iterator = 1;
    for (int i = 0; i < this.model.getDungeonRows(); i++) {
      for (int j = 0; j < this.model.getDungeonColumns(); j++) {
        int column = i;
        int row = j;

        String s = "";
        boolean playerPresent = false;
        if (locationPlayer == iterator) {
          playerPresent = true;
        }
        int r = row * 50;
        int c = (column + 1) * 50;
        int a = 50;
        int b = 50;
        s += "\n" + iterator;
        Color color = playerPresent ? Color.BLUE : Color.BLACK;
        color = this.model.getEndCave() == iterator ? Color.RED : color;
        if (!this.model.getAllCavesExplored().contains(iterator)) {
          s = "";
        }
        new GridView(r, c, a, b, s, color).draw(g3);
        iterator += 1;
      }
    }
  }

}
