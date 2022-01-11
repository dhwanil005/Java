package dungeon;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * class for creating our dungeon and performing various operations on it.
 * 
 */
public class Dungeon implements DungeonIntf {
  private int rows;
  private int columns;
  private int treasureAndArrowAvailability;
  private int interconnectivity;

  private int startNode;
  private int endNode;
  private ArrayList<Edge> mstR = new ArrayList<Edge>();
  private int numberOfMonsters;
  // private int arrowAvailability;
  private Player p1;
  protected boolean gameStatus = true;

  public HashMap<Integer, MonsterIntf> cavesWithMonsters = new HashMap<Integer, MonsterIntf>();

  /**
   * Enumeration for Directions.
   */

  public enum Directions {
    NORTH("North"), SOUTH("South"), EAST("East"), WEST("West");

    private String dir;

    Directions(String dir) {
      this.dir = dir;
    }

    public String getDirection(String dir) {
      return this.dir;
    }
  }

  /**
   * Constructor for initializing values.
   * 
   * @param rows                         the number of rows for our dungeon.
   * @param columns                      the number of columns for our dungeon.
   * @param interconnectivity            the degree of interconnectivity for our
   *                                     grid.
   * @param treasureAndArrowAvailability the percentage of caves that can have
   *                                     treasure in them.
   */
  public Dungeon(int rows, int columns, int interconnectivity, int treasureAndArrowAvailability,
      boolean wrapOrNot1, int numberOfMonsters) {

    this.rows = rows;
    this.endNode = endNode;
    this.columns = columns;
    boolean wrapOrNot = wrapOrNot1;
    this.interconnectivity = interconnectivity;
    this.numberOfMonsters = numberOfMonsters;
    // this.arrowAvailability = arrowAvailability;
    this.treasureAndArrowAvailability = treasureAndArrowAvailability;
    int[][] arr = new int[rows][columns];
    int vertices = rows * columns;
    Graph graph = new Graph(vertices);
    int num = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        arr[i][j] = num;
        num++;
      }
    }
    startPoint();
    endPoint();

    // ArrayList<Graph> allEdges = new ArrayList<Graph>();
    if (wrapOrNot) {
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
          if (i == 0) {
            graph.addEgde(arr[i][j], arr[rows - 1][j], (int) (Math.random() * 10) + 1);
          } else if (j == 0) {
            graph.addEgde(arr[i][j], arr[i][columns - 1], (int) (Math.random() * 10) + 1);
          } else if (i == rows - 1 && j == columns - 1) {
            graph.addEgde(arr[i][j], arr[i][j], (int) (Math.random() * 10) + 1);

          } else if (i == rows - 1) {
            graph.addEgde(arr[i][j], arr[i][j + 1], (int) (Math.random() * 10) + 1);
            graph.addEgde(arr[i][j], arr[0][j], (int) (Math.random() * 10) + 1);
          } else if (j == columns - 1) {
            graph.addEgde(arr[i][j], arr[i + 1][j], (int) (Math.random() * 10) + 1);
            graph.addEgde(arr[i][j], arr[i][0], (int) (Math.random() * 10) + 1);
          } else {
            graph.addEgde(arr[i][j], arr[i][j + 1], (int) (Math.random() * 10) + 1);
            graph.addEgde(arr[i][j], arr[i + 1][j], (int) (Math.random() * 10) + 1);
          }
        }
      }
      // System.out.println(mstR);
    } else {
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
          if (i == rows - 1 && j == columns - 1) {
            graph.addEgde(arr[i][j], arr[i][j], (int) (Math.random() * 10) + 1);

          } else if (i == rows - 1) {
            graph.addEgde(arr[i][j], arr[i][j + 1], (int) (Math.random() * 10) + 1);
          } else if (j == columns - 1) {
            graph.addEgde(arr[i][j], arr[i + 1][j], (int) (Math.random() * 10) + 1);
          } else {
            graph.addEgde(arr[i][j], arr[i][j + 1], (int) (Math.random() * 10) + 1);
            graph.addEgde(arr[i][j], arr[i + 1][j], (int) (Math.random() * 10) + 1);
          }
        }
      }
    }
    graph.kruskalMST();
    this.mstR = graph.getMst();
    if (this.interconnectivity > 1) {
      for (int i = 0; i < this.interconnectivity; i++) {
        int index = (int) (Math.random() * graph.getDiscarded().size());
        mstR.add(graph.getDiscarded().get(index));
      }
    }

  }

  @Override
  public void completedDungeon() {
    if (p1.getCurrentPosition() == this.endNode) {
      this.gameStatus = false;
    }
  }

  @Override
  public ArrayList<Edge> getMstR() {
    return this.mstR;
  }

  @Override
  public int getRows() {
    return this.rows;
  }

  @Override
  public boolean getGameStatus() {
    return this.gameStatus;
  }

  @Override
  public int getColumns() {
    return this.columns;
  }

  @Override
  public int getInterConnectivity() {
    return this.interconnectivity;
  }

  @Override
  public int getTreasureAndArrowAvailability() {
    return this.treasureAndArrowAvailability;
  }

  @Override
  public Player getPlayer(Player p) {
    if (p == null) {
      throw new IllegalArgumentException();
    }
    return p;
  }

  @Override
  public void enterDungeon(Player p) {
    this.p1 = p;

  }

  @Override
  public ArrayList<String> possibleMoves(int node) {
    ArrayList<String> directions = new ArrayList<String>();
    for (int i = 0; i < mstR.size(); i++) {

      if (mstR.get(i).getSource() == node) {
        if (mstR.get(i).getDestination() == node + this.columns) {
          directions.add(Directions.SOUTH.toString());

        } else if (mstR.get(i).getDestination() < mstR.get(i).getSource() + this.columns - 1) {
          directions.add(Directions.EAST.toString());

        }
      } else if (mstR.get(i).getDestination() == node) {
        if (mstR.get(i).getSource() == node - this.columns) {
          directions.add(Directions.NORTH.toString());

        } else if (mstR.get(i).getSource() > mstR.get(i).getDestination() - this.columns - 1) {
          directions.add(Directions.WEST.toString());

        }

      }

    }

    return directions;

  }

  public int numOfDirections(int node) {
    return possibleMoves(node).size();
  }

  @Override
  public void monsterAllocation() {
    if (getNumOfMonsters() == 1) {
      int end = getEndNode();
      cavesWithMonsters.put(end, new Monster());

    } else {
      int ct = getNumOfMonsters();
      int end = getEndNode();
      cavesWithMonsters.put(end, new Monster());
      for (int i = 0; i < ct - 1; i++) {
        int index = (int) (Math.random() * getMstR().size());
        cavesWithMonsters.put(index, new Monster());
      }
    }

  }

  @Override
  public int startPoint() {

    startNode = (int) (Math.random() * 5) + 1;
    return this.startNode;
  }

  @Override
  public int endPoint() {
    this.endNode = (int) (Math.random() * mstR.size() - 10) + 10;
    return this.endNode;
  }

  @Override
  public int getStartNode() {
    return this.startNode;
  }

  @Override
  public int getEndNode() {
    return this.endNode;
  }

  @Override
  public int getNumOfMonsters() {
    return this.numberOfMonsters;
  }

  @Override
  public HashMap<Integer, MonsterIntf> getMonsterMap() {
    return this.cavesWithMonsters;
  }
  

}
