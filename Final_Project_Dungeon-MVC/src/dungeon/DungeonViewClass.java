package dungeon;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 * Implementation of view Interface, Main view class in our MVC.
 */
public class DungeonViewClass extends JFrame implements DungeonViewIntf {

  private static final long serialVersionUID = 1L;
  private Painter painter;
  private ReadOnlyDungeonIntf model;
  private JLabel jj;
  private JLabel shoot;
  private JLabel pStats;
  private Menu menu;
  private MouseAdapter mouseListener;
  private KeyListener key;

  /**
   * Constructor to initialize for View Class.
   * 
   * @param model readonly model.
   */
  public DungeonViewClass(ReadOnlyDungeonIntf model) {
    super("Dungeon");
    if (model == null) {
      throw new IllegalArgumentException("Model should not be null");
    }
    this.model = model;
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setSize(1200, 1200);
    setLocation(200, 200);
    this.jj = new JLabel("Game Start");
    this.painter = new Painter(model);
    JScrollPane scroll = new JScrollPane(this.painter);
    this.painter.setPreferredSize(new Dimension(1200, 1200));
    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scroll.setBounds(50, 30, 300, 50);
    this.painter.setBounds(50, 30, 300, 50);
    pStats = new JLabel(model.getplayerDetails());
    shoot = new JLabel("Space to Shoot");
    add(this.jj, BorderLayout.NORTH);
    add(this.painter, BorderLayout.CENTER);
    add(shoot, BorderLayout.SOUTH);
    add(pStats, BorderLayout.EAST);
    this.menu = new Menu(this);
    pack();
  }

  @Override
  public void addClickListener(DungeonControllerIntf listener, KeyBoardController keyListener) {
    this.mouseListener = new ClickHelper(listener);
    this.key = new KeyBoardListener(keyListener, this);
    this.painter.addMouseListener(this.mouseListener);
    addKeyListener(this.key);
    this.menu.addClickListener(listener, model, this);
  }

  @Override
  public void refresh() {
    this.pStats.setText(model.getplayerDetails());
    this.painter.removeAll();
    this.painter.revalidate();
    this.painter.repaint();

    String s = " ";
    int locationPlayer = this.model.getPlayersCurrentLocation();
    if (locationPlayer == this.model.getEndCave()) {
      shoot.setText("Game Over!You Lose");
    }
    String treasure = this.model.displayAvailableTreasure(locationPlayer);
    String arrow = this.model.displayAvailableArrow(locationPlayer);
    String smell = this.model.displaySmell(locationPlayer);

    if (treasure != null) {
      s += "\n" + treasure;
    }
    if (arrow != null) {
      s += "\n" + arrow;
    }
    if (smell != null) {
      s += "\n" + smell;
    }
    if (!s.equals(" ")) {
      this.jj.setText("This cave contains:" + s);
    }

  }

  @Override
  public void makeVisible() {
    setVisible(true);

  }

  @Override
  public void removeClickListener() {
    this.painter.removeMouseListener(this.mouseListener);
    removeKeyListener(this.key);

  }

  @Override
  public void shootingHelper(int point) {
    if (point == 0) {
      this.shoot.setText("Space to shoot");

    } else if (point == 1) {
      this.shoot.setText("Press Arrow Keys to select direction");

    } else if (point == 2) {
      this.shoot.setText("Enter distance");
    }

  }

}
