package dungeon;

import dungeon.Dungeon.Directions;
import java.util.ArrayList;

/**
 * Class for Monster, we perform some operations on it like changing health and
 * checking if it is dead or not, updating health.
 * 
 */
public class Monster implements MonsterIntf {
  private int health;

  private int hit;

  private boolean deadOrNot;
  private String monsterLocation;

  /**
   * Constructor to set default values.
   * 
   * @param health    the health of monster.
   * @param deadOrNot check if it is dead or alive.
   */

  public Monster(int health, boolean deadOrNot) {
    this.hit = 50;
    this.health = 100;
    this.monsterLocation = "";
    this.deadOrNot = false;

  }

  /**
   * default constructor.
   */
  public Monster() {
    //for allocating monsters.
  }

  @Override
  public int getHealth() {
    return this.health;
  }

  @Override
  public boolean getDeadOrNot() {
    return this.deadOrNot;
  }

  @Override
  public String getMonLocation(int cave, Dungeon d) {
    if (d == null) {
      throw new IllegalArgumentException();
    }
    ArrayList<Integer> monsters = new ArrayList<Integer>(d.cavesWithMonsters.keySet());
    for (int i = 0; i < monsters.size(); i++) {

      if (cave + 2 == monsters.get(i)) {
        this.monsterLocation = Directions.EAST.toString();
        return Directions.EAST.toString();

      } else if (cave - 2 == monsters.get(i)) {
        this.monsterLocation = Directions.WEST.toString();
        return Directions.WEST.toString();

      } else if (cave - (d.getColumns() * 2) == monsters.get(i)) {
        this.monsterLocation = Directions.NORTH.toString();
        return Directions.NORTH.toString();

      } else if (cave + (d.getColumns() * 2) == monsters.get(i)) {
        this.monsterLocation = Directions.SOUTH.toString();
        return Directions.SOUTH.toString();

      } else if (cave + 1 == monsters.get(i)) {
        this.monsterLocation = Directions.EAST.toString();
        return Directions.EAST.toString();

      } else if (cave - 1 == monsters.get(i)) {
        this.monsterLocation = Directions.WEST.toString();
        return Directions.WEST.toString();

      } else if (cave + d.getColumns() == monsters.get(i)) {
        this.monsterLocation = Directions.NORTH.toString();
        return Directions.NORTH.toString();

      } else if (cave - d.getColumns() == monsters.get(i)) {
        this.monsterLocation = Directions.SOUTH.toString();
        return Directions.SOUTH.toString();

      }
    }
    return "";
  }

  @Override
  public int smellOfMonster(int cave, Dungeon d) {
    if (d == null) {
      throw new IllegalArgumentException();
    }
    ArrayList<Integer> monsters = new ArrayList<Integer>(d.cavesWithMonsters.keySet());
    for (int i = 0; i < monsters.size(); i++) {

      if (cave + 2 == monsters.get(i)) {
        this.monsterLocation = "EAST";
        return 1;

      } else if (cave - 2 == monsters.get(i)) {
        this.monsterLocation = "WEST";
        return 1;
      } else if (cave - (d.getColumns() * 2) == monsters.get(i)) {
        this.monsterLocation = "NORTH";
        return 1;
      } else if (cave + (d.getColumns() * 2) == monsters.get(i)) {
        this.monsterLocation = "SOUTH";
        return 1;
      } else if (cave + 1 == monsters.get(i)) {
        this.monsterLocation = "EAST";
        return 2;
      } else if (cave - 1 == monsters.get(i)) {
        this.monsterLocation = "WEST";
        return 2;

      } else if (cave + d.getColumns() == monsters.get(i)) {
        this.monsterLocation = "SOUTH";
        return 2;
      } else if (cave - d.getColumns() == monsters.get(i)) {
        this.monsterLocation = "NORTH";
        return 2;

      }
    }
    return 0;

  }

  @Override
  public String getMonsterLocation() {
    return this.monsterLocation;
  }

  @Override
  public int hitByArrow(boolean bool) {
    if (bool) {
      if (this.health <= 0) {
        deadOrNot = true;
      } else {
        return this.health = this.health - hit;
      }
    }
    return this.health;
  }

  @Override
  public void updateMonster(int cave, Dungeon d) {
    if (d == null) {
      throw new IllegalArgumentException();
    }
    if (deadOrNot) {
      d.getMonsterMap().remove(cave);
    }
  }
}
