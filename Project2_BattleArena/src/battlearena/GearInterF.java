package battlearena;

/**
 * Interface for Gear Class.
 */
public interface GearInterF {
  /**
   * Method for assigning random gear to players.
   */
  void gearAssign();

  /**
   * Calculates the effect of gear on players basic abilities.
   */
  void calculations(Player p1);

}
