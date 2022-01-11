package dungeon;

import dungeon.Dungeon.Directions;
import dungeon.Treasure.Treasures;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

/**
 * Player class implements PlayerIntf and with this class we initialize the
 * player and can move him with the help of methods like move ,currentLocation.
 * 
 */

public class Player implements PlayerIntf {
  private String name;

  private int currentPosition;
  private boolean isAlive = true;
  private boolean hitOrNot = false;
  private ArrayList<Integer> exploredCaves;

  // private int smellLevel;
  public HashMap<String, Integer> pickedUpItems = new HashMap<>();
  // ArrayList<Enum> treasureWithPlayer = new ArrayList<Enum>();
  // Treasure t1 = new Treasure();

  /**
   * Constructor to initialize the name of the player and the HashMap that has all
   * the items that are picked up by the player.
   * 
   * @param name the name of player.
   */
  public Player(String name) {
    this.name = name;
    pickedUpItems.put(Treasures.SAPPHIRE.toString(), 0);
    pickedUpItems.put(Treasures.RUBY.toString(), 0);
    pickedUpItems.put(Treasures.DIAMOND.toString(), 0);
    pickedUpItems.put("Arrow", 3);
    exploredCaves = new ArrayList<Integer>();
  }

  @Override
  public boolean getAlive() {
    return this.isAlive;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void currentPosition(Dungeon d) {
    if (d == null) {
      throw new IllegalArgumentException();
    }

    this.currentPosition = d.startPoint();
  }

  @Override
  public int getCurrentPosition() {
    return this.currentPosition;
  }

  @Override
  public void move(Directions direction, Dungeon d) {
    if (d == null) {
      throw new IllegalArgumentException();
    }
    if (!(d.possibleMoves(currentPosition).contains(direction.toString()))) {
      throw new IllegalArgumentException();
    }
    if (direction == Directions.SOUTH) {
      this.currentPosition = this.currentPosition + d.getColumns();

    } else if (direction == Directions.NORTH) {
      this.currentPosition = this.currentPosition - d.getColumns();
    } else if (direction == Directions.EAST) {
      this.currentPosition = this.currentPosition + 1;
    } else if (direction == Directions.WEST) {
      this.currentPosition = this.currentPosition - 1;
    }
    exploredCaves.add(this.currentPosition);
  }

  @Override
  public ArrayList<Integer> getExploredCaves() {
    return this.exploredCaves;
  }

  @Override
  public String pickUpTreasure(int cave, Treasure t) {
    if (t == null) {
      throw new IllegalArgumentException();
    }

    if (!t.getTreasureMap().containsKey(cave)) {
      return "Nothing";
    }
    String value = "";
    Map<Integer, String> nodesWithTreasure = t.getTreasureMap();
    value = nodesWithTreasure.get(cave);
    if (pickedUpItems.size() != 0) {
      int ct = pickedUpItems.get(value);
      pickedUpItems.replace(value, ct + 1);
    }
    return value;
  }

  @Override
  public String pickupArrow(int cave, Arrows a) {
    if (a == null) {
      throw new IllegalArgumentException();
    }

    if (!a.getArrowMap().containsKey(cave)) {
      return "Nothing!";
    }
    String value = "";
    HashMap<Integer, String> cavesWithArrow = a.getArrowMap();
    value = cavesWithArrow.get(cave);
    if (pickedUpItems.size() != 0) {
      int ct = pickedUpItems.get(value);
      pickedUpItems.replace(value, ct + 1);
    }
    return value;
  }

  @Override
  public HashMap<String, Integer> getPickedTreasure() {
    return this.pickedUpItems;
  }

  @Override
  public void updateArrow() {
    int ct = this.pickedUpItems.get("Arrows");
    this.pickedUpItems.replace("arrows", ct - 1);

  }

  @Override
  public boolean gethitOrNot() {
    return this.hitOrNot;
  }

  @Override
  public void attackMonster(int cave, String direction, int distance, Dungeon d, Monster m) {
    if (d == null) {
      throw new IllegalArgumentException();
    }
    if (m == null) {
      throw new IllegalArgumentException();
    }

    ArrayList<String> dir = d.possibleMoves(cave);

    if (dir.contains(direction) && direction.equals(m.getMonLocation(this.currentPosition, d))) {
      if (m.smellOfMonster(cave, d) == 2) {
        if (distance != 1) {
          updateArrow();
        } else {
          hitOrNot = true;
          m.hitByArrow(hitOrNot);
          updateArrow();
        }
      } else if (m.smellOfMonster(cave, d) == 1) {
        if (distance != 2) {
          updateArrow();
        } else {
          hitOrNot = true;
          m.hitByArrow(hitOrNot);
          updateArrow();
        }
      }
    }

  }

  @Override
  public void winOrLose(int cave, Dungeon d, Monster m) {
    if (d == null) {
      throw new IllegalArgumentException();
    }
    if (m == null) {
      throw new IllegalArgumentException();
    }

    if (d.getMonsterMap().containsKey(cave)) {
      if (d.getMonsterMap().get(cave).getDeadOrNot()) {
        this.isAlive = false;
      }
    }
  }

}
