package battlearena;

/**
 * Interface for Weapon Class.
 */

public interface WeaponIntF {
  /**
   * Method to assign Random Weapon to Player.
   */
  public String getRandomWeapon();

  /**
   * Calculates and returns the effect of the weapon assigned to the player on the
   * player's abilities.
   *
   * @param assignedWeapon the variable returned by method getRandomWeapon.
   */

  public int weaponRandomValue(String assignedWeapon, Player p);
}
