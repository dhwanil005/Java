package battlearena;

import java.util.Arrays;

/**
 * Player class for calculating basic abilities and other required calculations.
 */

public class Player implements PlayerInterF {
  private int health;
  private int strength;
  private int constitution;
  private int dexterity;
  private int charisma;
  private int strikingPower;
  private int avoidanceAbility;
  private int potentialStrikingDamage;
  private int actualDamage;

  Gear g1;
  Weapon w1;
  private String name;
  private int temp;

  /**
   * Constructor for player class calculates the basic abilities of the players.
   */
  public Player(String name) {
    this.strength = 0;
    this.constitution = 0;
    this.dexterity = 0;
    this.charisma = 0;
    this.name = name;
    g1 = new Gear();
    w1 = new Weapon();
    int[] dice = new int[4];
    for (int i = 0; i < 4; i++) {
      dice[i] = (int) (Math.floor(Math.random() * (6 - 2)) + 2);
    }
    Arrays.sort(dice);
    int sum = dice[1] + dice[2] + dice[3];
    this.strength = sum;
    int[] dice1 = new int[4];
    for (int i = 0; i < 4; i++) {
      dice1[i] = (int) (Math.floor(Math.random() * (6 - 2)) + 2);
    }
    Arrays.sort(dice1);
    int sum1 = dice1[1] + dice1[2] + dice1[3];
    this.constitution = sum1;
    int[] dice2 = new int[4];
    for (int i = 0; i < 4; i++) {
      dice2[i] = (int) (Math.floor(Math.random() * (6 - 2)) + 2);
    }
    Arrays.sort(dice2);
    int sum2 = dice2[1] + dice2[2] + dice2[3];
    this.dexterity = sum2;
    int[] dice3 = new int[4];
    for (int i = 0; i < 4; i++) {
      dice3[i] = (int) (Math.floor(Math.random() * (6 - 2)) + 2);
    }
    Arrays.sort(dice3);
    int sum3 = dice3[1] + dice3[2] + dice3[3];
    this.charisma = sum3;

  }

  public String getName() {
    return this.name;
  }

  public int getStrength() {
    return this.strength;
  }

  public int getConstitution() {
    return this.constitution;
  }

  public int getDexterity() {
    return this.dexterity;
  }

  public int getCharisma() {
    return this.charisma;
  }

  @Override
  public String toString() {
    return "Player Name=" + this.name + ", Strength=" + strength + ", Constitution=" + constitution
        + ", Dexterity=" + dexterity + ", Charisma=" + charisma + ", Health=" + calculateHealth()
        + " , strikingPower=" + calculateStrikingPower() + ", avoidanceAbility="
        + this.calculateAvoidanceAbility() + ", potentialStrikingDamage="
        + calculatePotentialStrikingDamage() + ", playersWeapon=" + w1.getRandomWeapon();
  }

  @Override
  public int calculateStrikingPower() {
    this.strikingPower = this.strength + (int) (Math.floor(Math.random() * 10) + 1)
        + g1.getStrengthAffected();
    return this.strikingPower;
  }

  @Override
  public int calculateHealth() {
    this.health = this.strength + this.constitution + this.dexterity + this.charisma;

    return this.health;
  }

  public int getHealth() {
    return this.health;
  }

  @Override
  public int calculateAvoidanceAbility() {
    this.avoidanceAbility = this.dexterity + +(int) Math.floor(Math.random() * 6 + 1)
        + g1.getDexterityAffected();
    this.temp = this.avoidanceAbility;
    return this.avoidanceAbility;
  }

  @Override
  public int calculatePotentialStrikingDamage() {
    String playersWeapon;
    playersWeapon = w1.getRandomWeapon();
    this.potentialStrikingDamage = this.strength + w1.weaponRandomValue(playersWeapon, this);
    return this.potentialStrikingDamage;
  }

  public int getPsd() {
    return this.potentialStrikingDamage;
  }

  public int getAvoidanceAbility() {
    return this.avoidanceAbility;
  }

  @Override
  public void attack(Player p2) {
    if (this.getPsd() >= p2.updateAvoidanceAbility()) {
      this.actualDamage = this.strikingPower - p2.constitution;
      if (this.actualDamage > 0) {
        p2.changeHealth(actualDamage);

      } else {
        setAvoidanceAbility();
      }
    }

  }

  @Override
  public int changeHealth(int actualDamage) {
    this.health = this.health - actualDamage;
    return this.health;
  }

  @Override
  public int setAvoidanceAbility() {

    this.temp = this.temp - 5;
    return this.temp;

  }

  @Override
  public int updateAvoidanceAbility() {
    return this.temp;

  }
}
