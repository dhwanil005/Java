package battlearena;

/**
 * class for arena to start game, get turn, get winner.
 */
public class Arena {
  Player[] playersInArena;

  public Arena() {
    playersInArena = new Player[2];
  }

  /**
   * Method for entering players in the game.
   */

  public Player[] enterArena(Player p1, Player p2) {
    this.playersInArena[0] = p1;
    this.playersInArena[1] = p2;
    return playersInArena;

  }

  /**
   * Checking who will strike first.
   */
  public Player getTurn(Player p1, Player p2) {
    
    if (playersInArena[0].getCharisma() >= playersInArena[1].getCharisma()) {
      return playersInArena[0];
    } else {
      return playersInArena[1];
    }
  }
}
