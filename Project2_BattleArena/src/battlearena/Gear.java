package battlearena;

/**
 * Gear class, assigns gear to player and calculates what affects are made to
 * their basic abilities.
 *
 */

public class Gear implements GearInterF {
  int countForHeadgear;
  int countForPotions;
  int countForBelts;
  int countForFootwear;

  int constitutionAffected;
  int charsimaAffected;
  int strengthAffected;
  int dexterityAffected;

  @Override
  public void gearAssign() {
    for (int i = 1; i <= 20; i++) {
      int rand = (int) Math.floor(Math.random() * (20 - 1 + 1) + 1);
      if (rand <= 3 && countForHeadgear < 1) {
        this.countForHeadgear++;

      } else if (rand <= 11) {
        this.countForPotions++;

      } else if (rand <= 18) {
        this.countForBelts++;
      } else if (rand <= 20 && countForFootwear < 1) {
        this.countForFootwear++;

      }

    }
  }

  @Override
  public void calculations(Player p1) {
    int gc = p1.getConstitution();
    this.constitutionAffected = gc + this.countForHeadgear * 10;
    int gs = p1.getStrength();
    this.strengthAffected = gs + this.countForPotions * 1;
    int gch = p1.getCharisma();
    this.charsimaAffected = gch + this.countForBelts * 1;
    int gd = p1.getDexterity();
    this.dexterityAffected = gd + this.countForFootwear * 10;

  }

  @Override
  public String toString() {
    return "Headgear assigned to player:" + this.countForHeadgear
        + ",Potions assigned to the player:" + this.countForPotions
        + ",Belts assigned to the player:" + this.countForBelts + ", Footwear assigned to player:"
        + this.countForFootwear;
  }

  public int getConstitutionAffected() {
    return this.constitutionAffected;
  }

  public int getStrengthAffected() {
    return this.strengthAffected;
  }

  public int getCharsimaAffected() {
    return this.charsimaAffected;
  }

  public int getDexterityAffected() {
    return this.dexterityAffected;

  }

  public int getCountForHeadgear() {
    return this.countForHeadgear;
  }

  public int getCountForBelts() {
    return this.countForBelts;
  }

  public int getCountForPotions() {
    return this.countForPotions;
  }

  public int getCountForFootwear() {
    return this.countForFootwear;
  }
}
