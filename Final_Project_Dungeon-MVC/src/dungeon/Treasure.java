package dungeon;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for treasure we allocate treasure in the dungeon with the help of
 * methods present in this class and store them in a hashMap with the index as
 * cave number and key as the type of treasure.
 */

public class Treasure implements TreasureIntf {
  // Dungeon d = new Dungeon();
  // private ArrayList<Integer> nodesWithTreasure = new ArrayList<Integer>();
  private Map<Integer, String> nodesWithTreasures = new HashMap<>();

  /**
   * Enumeration for Treasure with every type of treasure available.
   *
   */
  public enum Treasures {
    SAPPHIRE("Sapphire"), RUBY("Ruby"), DIAMOND("Diamond");

    private String string;

    Treasures(String string) {
      this.string = string;
    }

    public String treasures(String string) {
      return this.string;
    }
  }

  @Override
  public void treasureAllocation(int treasureAndArrowAvailability, Dungeon d) {
    if (d == null) {
      throw new IllegalArgumentException();
    }

    if (d.getTreasureAndArrowAvailability() > 0) {

      int cavesWithTreasure = (int) (Math
          .floor((d.getMstR().size() * treasureAndArrowAvailability) / 100));
      for (int i = 0; i < cavesWithTreasure; i++) {
        int index = (int) (Math.random() * d.getMstR().size());
        int randTreasure = (int) (Math.random() * 3) + 1;
        if (randTreasure == 1) {
          nodesWithTreasures.put(d.getMstR().get(index).getSource(), Treasures.SAPPHIRE.toString());
        } else if (randTreasure == 2) {
          nodesWithTreasures.put(d.getMstR().get(index).getSource(), Treasures.RUBY.toString());
        } else {
          nodesWithTreasures.put(d.getMstR().get(index).getSource(), Treasures.DIAMOND.toString());
        }

      }

    }

  }

  @Override
  public void updateTreasure(int cave) {
    this.nodesWithTreasures.remove(cave);
  }

  @Override
  public Map<Integer, String> getTreasureMap() {
    return this.nodesWithTreasures;
  }

}
