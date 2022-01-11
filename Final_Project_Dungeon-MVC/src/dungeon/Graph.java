package dungeon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Graph class that implements graph interface.
 */

public class Graph implements GraphIntf {
  private int vertices;
  private ArrayList<Edge> allEdges = new ArrayList<>();
  private ArrayList<Edge> discarded = new ArrayList<>();
  private ArrayList<Edge> mst = new ArrayList<>();

  /**
   * constructor for graph class.
   * 
   * @param vertices row*columns.
   */
  Graph(int vertices) {
    this.vertices = vertices;
  }

  @Override
  public void addEgde(int source, int destination, int weight) {
    Edge edge = new Edge(source, destination, weight);
    allEdges.add(edge);
  }

  @Override
  public void kruskalMST() {
    PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(),
        Comparator.comparingInt(o -> o.weight));

    for (int i = 0; i < allEdges.size(); i++) {
      pq.add(allEdges.get(i));
    }

    int[] parent = new int[vertices];

    makeSet(parent);

    int index = 0;
    while (index < allEdges.size()) {
      Edge edge = pq.remove();

      int xx = find(parent, edge.source);
      int yy = find(parent, edge.destination);

      if (xx == yy) {
        discarded.add(edge);
        index++;
      } else {

        this.mst.add(edge);
        index++;
        union(parent, xx, yy);
      }
    }

  }

  @Override
  public void makeSet(int[] parent) {

    for (int i = 0; i < vertices; i++) {
      parent[i] = i;
    }
  }

  public ArrayList<Edge> getDiscarded() {
    return this.discarded;
  }

  @Override
  public int find(int[] parent, int vertex) {

    if (parent[vertex] != vertex) {
      return find(parent, parent[vertex]);
    } else {
      return vertex;
    }
  }

  @Override
  public void union(int[] parent, int x, int y) {
    int xparent = find(parent, x);
    int ysetparent = find(parent, y);
    parent[ysetparent] = xparent;
  }

  /**
   * getter method for mst.
   * 
   * @return arraylist mst.
   */
  public ArrayList<Edge> getMst() {

    return this.mst;
  }

}
