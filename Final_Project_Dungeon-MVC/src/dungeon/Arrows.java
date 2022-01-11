package dungeon;

import java.util.HashMap;

/**
 * Class for Arrow where it contains methods for its allocation and other
 * operations for arrows.
 */
public class Arrows implements ArrowIntf {

  // Dungeon d = new Dungeon();
  HashMap<Integer, String> arrowMap;

  /**
   * arrow constructor.
   */
  public Arrows() {
    arrowMap = new HashMap<Integer, String>();
  }

  @Override
  public void arrowAllocation(int treasureAndArrowAvailability, Dungeon d) {
    if (d == null) {
      throw new IllegalArgumentException();
    }

    if (d.getTreasureAndArrowAvailability() > 0) {
      int cavesWithArrows = (int) (Math
          .floor((d.getMstR().size() * d.getTreasureAndArrowAvailability()) / 100));
      for (int i = 0; i < cavesWithArrows; i++) {
        int index = (int) (Math.random() * d.getMstR().size());
        arrowMap.put(index, "Arrow");
      }
    }
  }

  @Override
  public HashMap<Integer, String> getArrowMap() {
    return this.arrowMap;
  }

  @Override
  public void updateArrows(int cave) {
    this.arrowMap.remove(cave);
  }
}