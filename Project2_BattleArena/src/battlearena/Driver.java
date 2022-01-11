package battlearena;

/**
 * Class to run our Role Playing Game.
 */
public class Driver {
  /**
   * main class to run our game.
   */

  public static void main(String[] args) {
    Player p1 = new Player("Dhwanil");

    int round = 0;
    int round1 = 0;

    System.out.println("Details of Player1:");
    System.out.println("");
    System.out.println(p1.toString());
    System.out.println("");
    Gear g1 = new Gear();
    g1.gearAssign();
    System.out.println(g1.toString());
    g1.calculations(p1);
    System.out.println("");

    System.out.println("Details of Player2:");
    Player p2 = new Player("Abhi");
    System.out.println("");
    System.out.println(p2.toString());
    System.out.println("");
    Gear g2 = new Gear();
    g2.gearAssign();
    System.out.println(g2.toString());
    g2.calculations(p2);
    System.out.println("");
    Arena a1 = new Arena();

    a1.enterArena(p1, p2);
    int game = 0;
    while (game == 0) {
      if (p1.getHealth() <= 0 || p2.getHealth() <= 0) {
        if (p1.getHealth() <= 0) {
          System.out.println(p2.getName() + " wins");
        }
        if (p2.getHealth() <= 0) {
          System.out.println(p1.getName() + " wins");
        }
        break;
      } else {
        if (a1.getTurn(p1, p2) == p1) {
          round++;
          System.out.println(
              p1.getName() + "'s Health after round  " + round + "  is:  " + p1.getHealth());

          System.out.println(
              p2.getName() + "'s    Health after round  " + round + "  is:  " + p2.getHealth());
          System.out.println("");
          p1.attack(p2);
          p2.attack(p1);
        } else {

          round1++;
          System.out.println(
              p1.getName() + "'s Health after round  " + round1 + "  is:  " + p1.getHealth());
          System.out.println(
              p2.getName() + "'s    Health after round  " + round1 + "  is:  " + p2.getHealth());
          System.out.println("");
          p2.attack(p1);
          p1.attack(p2);

        }
      }

    }
  }
}
