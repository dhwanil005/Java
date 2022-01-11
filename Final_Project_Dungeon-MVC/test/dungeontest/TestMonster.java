package dungeontest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dungeon.Dungeon;
import dungeon.Monster;

/**
 * TEsting monster class.
 * 
 */
public class TestMonster {
  Monster m = new Monster();
  Dungeon d = new Dungeon(6, 8, 1, 20, false, 1);

  @Test
  public void testMonsterAtEndCave() {
    d.monsterAllocation();
    assertEquals(1, d.getMonsterMap().size());
  }

  @Test
  public void testHealth() {
    d.monsterAllocation();
    // int prevHealth = m.getHealth();
    m.hitByArrow(true);
    assertEquals(50, m.getHealth());
  }

  @Test
  public void testSmell() {
    d.monsterAllocation();
    int endNode = d.endPoint();
    int temp = m.smellOfMonster(endNode - 8, d);
    assertEquals(2, temp);
  }

  @Test
  public void testHealth2() {
    d.monsterAllocation();

    m.hitByArrow(true);
    m.hitByArrow(true);
    assertEquals(0, m.getHealth());
  }

  @Test
  public void kill() {
    d.monsterAllocation();
    m.hitByArrow(true);
    m.hitByArrow(true);
    assertEquals(false, m.getDeadOrNot());
  }

}
