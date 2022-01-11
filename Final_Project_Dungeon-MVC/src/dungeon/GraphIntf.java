package dungeon;

import java.util.ArrayList;

/**
 * This interface helps us create a graph and do the required operations to
 * create one.
 */
public interface GraphIntf {
  /**
   * This method helps us to add Edges to an ArrayList named allEdges.
   * 
   * @param source      the start point of the edge.
   * @param destination the end point of the edge.
   * @param weight      the weight that we calculate randomly for the edge.
   */
  public void addEgde(int source, int destination, int weight);

  /**
   * This method adds all the edges to a priority queue, sort them based on their
   * weights and check if adding a certain edge to the graph would create a cycle
   * or not.
   */
  public void kruskalMST();

  /**
   * This method we create a new element with a parent pointer to itself.
   * 
   */

  public void makeSet(int[] parent);

  /**
   * getter for Arraylist mst.
   * 
   * @return all the edges present in our graph.
   */
  public ArrayList<Edge> getMst();

  /**
   * getter for ArrayList discarded.
   * 
   * @return all the discarded edges.
   */
  public ArrayList<Edge> getDiscarded();

  /**
   * Traverse through the parent nodes and find an element whose parent is itself.
   * 
   * @param parent bunch of parent nodes in the tree.
   * @param vertex the vertex at which we find the element who is a parent of
   *               itself.
   * @return the node and vertex.
   */

  public int find(int[] parent, int vertex);

  /**
   * Makes x a parent of y.
   */
  public void union(int[] parent, int x, int y);

}
