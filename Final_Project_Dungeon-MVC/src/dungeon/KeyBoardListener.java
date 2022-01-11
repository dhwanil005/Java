package dungeon;

import dungeon.Dungeon.Directions;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Class to help listen to any key inputs.
 */
public class KeyBoardListener implements KeyListener {
  private KeyBoardController listener;
  private Map<Integer, Directions> cont;
  private Map<Integer, Callable<String>> funcController;
  private Map<Integer, Directions> arrows;
  private Map<Integer, Integer> dist;
  private boolean shootDir;
  private boolean shootDist;
  private Directions direction;
  private int dista;
  private DungeonViewIntf view;
  private boolean inRange;

  /**
   * Constructor for key board listener.
   * 
   * @param listener object of controller.
   * @param view     object of view.
   */
  public KeyBoardListener(KeyBoardController listener, DungeonViewIntf view) {
    super();
    if (listener == null) {
      throw new IllegalArgumentException("null listener");
    }
    if (view == null) {
      throw new IllegalArgumentException("null view");
    }
    this.listener = listener;
    this.view = view;
    cont = new HashMap<>();
    cont.put(KeyEvent.VK_W, Directions.NORTH);
    cont.put(KeyEvent.VK_A, Directions.WEST);
    cont.put(KeyEvent.VK_S, Directions.SOUTH);
    cont.put(KeyEvent.VK_D, Directions.EAST);
    this.funcController = new HashMap<>();
    this.funcController.put(KeyEvent.VK_P, this::pickup);
    this.funcController.put(KeyEvent.VK_SPACE, this::shoot);
    this.arrows = new HashMap<>();
    arrows.put(KeyEvent.VK_UP, Directions.NORTH);
    arrows.put(KeyEvent.VK_LEFT, Directions.WEST);
    arrows.put(KeyEvent.VK_DOWN, Directions.SOUTH);
    arrows.put(KeyEvent.VK_RIGHT, Directions.EAST);
    this.dist = new HashMap<>();
    dist.put(KeyEvent.VK_1, 1);
    dist.put(KeyEvent.VK_2, 2);
    resetRange();

  }

  private void resetRange() {
    dista = 0;
    direction = null;
    inRange = false;
    this.view.shootingHelper(0);

  }

  @Override
  public void keyTyped(KeyEvent e) {
    // Extra method

  }

  @Override
  public void keyPressed(KeyEvent e) {
    int keyPress = e.getKeyCode();
    if (this.cont.containsKey(keyPress)) {
      move(keyPress);
    } else if (this.funcController.containsKey(keyPress)) {
      try {
        this.funcController.get(keyPress).call();
      } catch (Exception e1) {
        // Error in call.
      }
    } else if (this.dist.containsKey(keyPress)) {
      fetchDist(keyPress);
    } else if (this.arrows.containsKey(keyPress)) {
      fetchDir(keyPress);
    }

  }

  private void fetchDist(int keyPress) {
    if (shootDist) {
      dista = this.dist.get(keyPress);
      this.shoot();
    } else {
      this.resetRange();
    }
  }

  private void fetchDir(int keyPress) {
    if (shootDir) {
      direction = this.arrows.get(keyPress);
      this.shoot();
    } else {
      this.resetRange();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    // Extra Method

  }

  private String shoot() {
    try {
      if (dista != 0 && direction != null) {
        this.listener.shoot(dista, direction);
        resetRange();
        this.view.refresh();
      } else {
        inRange = true;

        if (direction == null && !shootDist) {
          shootDir = true;
          this.view.shootingHelper(1);
        } else if (direction != null && dista == 0) {
          shootDist = true;
          this.view.shootingHelper(2);
        }
      }
    } catch (NumberFormatException e) {
      // Ignore
    }
    return null;
  }

  private String pickup() {
    try {
      this.listener.pickup();
    } catch (NumberFormatException e) {
      // ignore
    }
    return null;
  }

  private void move(int keyPress) {
    this.listener.move(this.cont.get(keyPress));
    this.view.refresh();
  }

}
