package dungeon;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import java.awt.geom.Rectangle2D;

/**
 * Class to generate our dungeon.
 */
public class GridView extends Rectangle {

  private static final long serialVersionUID = 1L;
  private int x;
  private int y;
  private int width;
  private int height;
  private Color color;
  private String txt;

  /**
   * Constructor for our GridView Class.
   * 
   * @param x      X Coordinate.
   * @param y      y Coordinate.
   * @param width  The rectangle's width.
   * @param height the Rectangle's Height.
   * @param txt    Text that will be inside grids.
   * @param color  color.
   */
  public GridView(int x, int y, int width, int height, String txt, Color color) {
    super(x, y, width, height);
    this.txt = txt;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.color = color;
  }

  /**
   * Drawing each rectangle of GridView on the screen.
   * 
   * @param g Object of Graphics.
   */
  public void draw(Graphics g) {
    Graphics2D g1 = (Graphics2D) g;
    g1.setColor(this.color);

    g1.draw(new Rectangle2D.Double(x, y, width, height));
    int xc = x + (width) / 2;
    int yc = (int) (y + (height) / 2);

    this.drawString(g1, txt, (int) xc, (int) yc);

  }

  private void drawString(Graphics g, String txt, int x, int y) {
    for (String ln : txt.split("\n")) {
      g.drawString(ln, x, y);
    }
  }
}
