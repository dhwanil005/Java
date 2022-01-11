package battlearena;

/**
 * Weapon class for assigning weapon to the player and calculating the effect it
 * makes on their basic abilities.
 */
public class Weapon implements WeaponIntF {
  private String[] weapons = new String[] { "Katana", "Broadswords", "Two-Handed Swords", "Flail",
      "Axe" };

  private int katanaDamage;
  private int broadswordsDamage;
  private int twoHandedSwordsDamage;
  private int flailDamage;
  private int axeDamage;

  @Override
  public String getRandomWeapon() {
    String assignedWeapon;
    int rand = (int) (Math.floor(Math.random() * (5 - 0)) + 0);
    assignedWeapon = weapons[rand];
    return assignedWeapon;
  }

  @Override
  public int weaponRandomValue(String assignedWeapon, Player p1) {
    if (assignedWeapon.equals("Katana")) {
      this.katanaDamage = (int) (Math.floor(Math.random() * (6 - 4)) + 4);
      return this.katanaDamage;
    } else if (assignedWeapon.equals("Broadswords")) {
      this.broadswordsDamage = (int) (Math.floor(Math.random() * (10 - 6)) + 6);
      return broadswordsDamage;
    } else if (assignedWeapon.equals("Two-Handed Swords")) {
      this.twoHandedSwordsDamage = (int) (Math.floor(Math.random() * (12 - 8)) + 8);
      if (p1.getStrength() < 14) {
        return (int) this.twoHandedSwordsDamage / 2;
      } else {
        return this.twoHandedSwordsDamage;

      }
    } else if (assignedWeapon.equals("Flail")) {
      this.flailDamage = (int) (Math.floor(Math.random() * (12 - 8)) + 8);
      if (p1.getDexterity() < 14) {
        return (int) this.flailDamage / 2;
      } else {
        return this.flailDamage;
      }
    } else if (assignedWeapon.equals("Axe")) {
      this.axeDamage = (int) (Math.floor(Math.random() * (10 - 6)) + 6);
      return this.axeDamage;

    } else {
      return 0;

    }
  }
}