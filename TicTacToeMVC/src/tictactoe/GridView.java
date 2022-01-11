package tictactoe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;

/**
 * Class to represent the grid of our tictactoe game.
 */
public class GridView extends Rectangle {
  
  private int x;
  private int y;
  private int height;
  private int width;
  private String txt;

  /**
   * Constructor for our Grid class.
   * 
   * @param x      x coordinate.
   * @param y      y coordinate.
   * @param width  rect width.
   * @param height rect height.
   * @param txt    text to be displayed inside rectangle.
   */
  public GridView(int x, int y, int width, int height, String txt) {
    super(x, y, width, height);
    this.txt = txt;
    this.x = x;
    this.y = y;
    this.height = height;
    this.width = width;
  }

  /**
   * Representing a Rectangle in grid using graphic object provided.
   * 
   * @param g Graphics Object
   */
  public void draw(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g2.draw(new Rectangle2D.Double(x, y, width, height));
    Font f = g2.getFont();
    FontRenderContext c = g2.getFontRenderContext();
    g2.setFont(f);
    
    int tw = (int) f.getStringBounds(txt, c).getWidth();
    LineMetrics lm = f.getLineMetrics(txt, c);
    int th = (int) (lm.getAscent() + lm.getDescent());
    int i = x + (width - tw) / 2;
    int j = (int) (y + (height + th) / 2 - lm.getDescent());
    g2.setColor(Color.blue);
    g2.drawString(txt, (int) i, (int) j);
  }

}
