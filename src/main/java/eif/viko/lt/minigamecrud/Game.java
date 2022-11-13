package eif.viko.lt.minigamecrud;

public class Game {
  private Bank bank;
  private Player player;

  public Game(Bank bank, Player player) {
    this.bank = bank;
    this.player = player;
  }

  public String start() {
    return
        bank + "\n----------------------------------------\n"
            + "VS"
            + "\n----------------------------------------\n"
            + player;
  }
}
