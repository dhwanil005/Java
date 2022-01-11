package dungeon;

import java.util.ArrayList;

import dungeon.Dungeon.Directions;

/**
 * Main Model Class where required methods are called for seamless execution.
 */
public class Game implements Model {
  private Player player;
  private Dungeon dungeon;
  private Treasure treasure;
  private Arrows arrow;
  private Monster monster;
  private int rows;
  private int columns;
  private int treasureAndArrowAvailability;
  private int interConnectivity;
  private boolean wrapOrNot;
  private int numberOfMonsters;
  private String playerName;
  private static final int min_value = 0;
  private static final int min_dimension = 5;

  /**
   * Constructor for Game class.
   * 
   * @param rows                         rows
   * @param columns                      columns
   * @param interConnectivity            interconnectivity of dungeon.
   * @param treasureAndArrowAvailability percentage of caves that have treasure
   *                                     and arrows.
   * @param wrapOrNot                    whether dungeon is wrap or not.
   * @param numberOfMonsters             total number of monsters
   * @param playerName                   name of player
   */
  public Game(int rows, int columns, int interConnectivity, int treasureAndArrowAvailability,
      boolean wrapOrNot, int numberOfMonsters, String playerName) {
    if (interConnectivity < min_value) {
      throw new IllegalArgumentException("Interconnectivity should not be less than" + min_value);
    }
    if (treasureAndArrowAvailability < min_value) {
      throw new IllegalArgumentException("Availability should not be less than" + min_value);
    }
    if (playerName.length() < min_value) {
      throw new IllegalArgumentException(
          "Player's Name should be greater than" + min_value + "characters");
    }
    if (rows < min_dimension || columns < min_dimension) {
      throw new IllegalArgumentException("Dimensions should be greater than" + min_dimension);

    }
    if (numberOfMonsters < min_value) {
      throw new IllegalArgumentException("Number of monsters should at least be 1(end cave");
    }
    dungeon = new Dungeon(rows, columns, interConnectivity, treasureAndArrowAvailability, wrapOrNot,
        numberOfMonsters);
    this.player = new Player(playerName);

    this.rows = rows;
    this.columns = columns;
    this.wrapOrNot = wrapOrNot;
    this.interConnectivity = interConnectivity;
    this.numberOfMonsters = numberOfMonsters;
    this.treasureAndArrowAvailability = treasureAndArrowAvailability;
    this.playerName = playerName;
    this.treasure = new Treasure();
    this.arrow = new Arrows();
    this.monster = new Monster();
    dungeon.enterDungeon(player);
    treasure.treasureAllocation(20, dungeon);
    arrow.arrowAllocation(treasureAndArrowAvailability, dungeon);
    dungeon.monsterAllocation();
    dungeon.startPoint();
    dungeon.endPoint();
    player.currentPosition(dungeon);
  }

  @Override
  public int getDungeonRows() {
    return this.rows;
  }

  @Override
  public int getDungeonColumns() {
    return this.columns;
  }

  @Override
  public String getAllPlayersPickUpDetails() {
    return this.player.getPickedTreasure().toString();
  }

  @Override
  public boolean isPlayerAlive() {
    return this.player.getAlive();
  }

  @Override
  public String getplayerDetails() {
    String s = "";
    s = "Name: " + this.player.getName() + "\n" + "Picked Up Items: " + this.player.pickedUpItems
        + this.dungeon.possibleMoves(this.player.getCurrentPosition());
    return s;
  }

  @Override
  public boolean isGameOver() {

    return this.player.getCurrentPosition() == this.dungeon.getEndNode() || !this.player.getAlive();
  }

  @Override
  public int getPlayersCurrentLocation() {
    return this.player.getCurrentPosition();
  }

  @Override
  public int getEndCave() {
    return this.dungeon.getEndNode();
  }

  @Override
  public String movePlayer(Directions direction) {
    this.player.move(direction, dungeon);

    String s = "This is your Current Position" + this.player.getCurrentPosition() + "\n"
        + "Available Arrows at this cave:- "
        + this.displayAvailableArrow(this.player.getCurrentPosition()) + "\n"
        + "Treasure Available at this cave: "
        + this.displayAvailableTreasure(this.player.getCurrentPosition())
        + this.displaySmell(this.player.getCurrentPosition());
    return s;
  }

  @Override
  public String displayAvailableArrow(int cave) {
    if (arrow.getArrowMap().containsKey(this.player.getCurrentPosition())) {
      String value = arrow.getArrowMap().get(this.player.getCurrentPosition());
      return value;
    } else {
      return "";
    }
  }

  @Override
  public String displayAvailableTreasure(int cave) {
    if (treasure.getTreasureMap().containsKey(this.player.getCurrentPosition())) {
      String t = treasure.getTreasureMap().get(this.player.getCurrentPosition());
      return t;
    } else {
      return "";
    }
  }

  @Override
  public String displaySmell(int cave) {
    this.monster.getMonLocation(this.getPlayersCurrentLocation(), dungeon);
    this.monster.smellOfMonster(1, dungeon);
    if (this.monster.smellOfMonster(this.getPlayersCurrentLocation(), dungeon) == 2) {
      return "You Smell Something Weird";
    } else if (this.monster.smellOfMonster(this.getPlayersCurrentLocation(), dungeon) == 1) {
      return "You Smell a Strong Weird Smell";
    } else {
      return "No Monsters near";
    }
  }

  @Override
  public String pikcupItemsCave() {
    String ar = this.player.pickupArrow(this.player.getCurrentPosition(), arrow);
    this.arrow.updateArrows(this.player.getCurrentPosition());

    String tr = this.player.pickUpTreasure(this.player.getCurrentPosition(), treasure);
    this.treasure.updateTreasure(this.player.getCurrentPosition());

    return tr + ar;
  }

  @Override
  public String shoot(Directions dir, int distance) {
    this.player.attackMonster(this.player.getCurrentPosition(), dir.toString(), distance, dungeon,
        monster);
    if (this.player.gethitOrNot()) {
      return "Hear a wailing sound in the dark";
    } else {
      return "Missed Arrow";
    }
  }

  @Override
  public int getDungeonTreasureAndArrowAvailability() {

    return this.treasureAndArrowAvailability;
  }

  @Override
  public int getDungeonNumberOfMonsters() {
    return this.numberOfMonsters;
  }

  @Override
  public boolean getDungeonWrapOrNot() {
    return this.wrapOrNot;
  }

  @Override
  public int getDungeonInterConnectivity() {
    return this.interConnectivity;
  }

  @Override
  public String getPlayerName() {
    return this.playerName;
  }

  @Override
  public void startGame(int rows, int columns, int interConnectivity,
      int treasureAndArrowAvailability, boolean wrapOrNot, int numberOfMonsters,
      String playerName) {
    if (playerName != null) {
      this.playerName = playerName;
    }
    this.rows = rows;
    this.columns = columns;
    this.wrapOrNot = wrapOrNot;
    this.interConnectivity = interConnectivity;
    this.numberOfMonsters = numberOfMonsters;
    this.treasureAndArrowAvailability = treasureAndArrowAvailability;

    dungeon = new Dungeon(rows, columns, interConnectivity, treasureAndArrowAvailability, wrapOrNot,
        numberOfMonsters);
    this.player = new Player(playerName);
  }

  @Override
  public void reset() {
    this.player.currentPosition(dungeon);

  }

  @Override
  public ArrayList<Integer> getAllCavesExplored() {
    return this.player.getExploredCaves();
  }

}
