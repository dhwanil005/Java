package battlearena;

/**
 * Interface for Player Class.
 */

public interface PlayerInterF {

  /**
   * Calculates and returns health.
   */
  int calculateHealth();

  /**
   * Calculates and returns Striking Power.
   */

  int calculateStrikingPower();

  /**
   * Calculates and returns Avoidance Ability.
   */

  int calculateAvoidanceAbility();

  /**
   * Calculates and returns Striking Damage.
   */

  int calculatePotentialStrikingDamage();

  /**
   * Attacking .
   */
  void attack(Player p2);

  /**
   * Changing the health of players if actual damage>0.
   */
  public int changeHealth(int actualDamage);

  /**
   * Setting avoidance ability so that game doesnt go into loop.
   */
  public int setAvoidanceAbility();

  /**
   * upadting avoidance ability.
   */
  public int updateAvoidanceAbility();
}
