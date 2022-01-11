package dungeon;

/**
 * edge class for making and inserting edges.
 * 
 */
public class Edge {
  protected int source;
  protected int destination;
  protected int weight;

  /**
   * Constructor to initialize variables for source(starting node)
   * destination(ending node) and weight(randomly).
   */
  public Edge(int source, int destination, int weight) {
    this.source = source;
    this.destination = destination;
    this.weight = weight;
  }

  /**
   * getter method for source.
   * 
   * @return the source.
   */
  public int getSource() {
    return this.source;
  }

  /**
   * getter method for destination.
   * 
   * @return the destination.
   */
  public int getDestination() {
    return this.destination;
  }
}
