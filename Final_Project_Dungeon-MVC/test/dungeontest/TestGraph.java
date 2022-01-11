package dungeontest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dungeon.Dungeon;
import dungeon.Edge;

/**
 * Test class for graph.
 */
public class TestGraph {

  private Dungeon d1;
  private Edge e1;

  /**
   * Setting up graph.
   */
  @Before
  public void setup() {

    d1 = new Dungeon(6, 8, 2, 20, false, 1);
    e1 = new Edge(1, 2, 4);
  }

  @Test
  public void testVertices() {
    assertEquals(48, d1.getRows() * d1.getColumns());
  }

  @Test
  public void testAddEdge() {
    assertEquals(1, e1.getSource());
    assertEquals(2, e1.getDestination());

  }
}