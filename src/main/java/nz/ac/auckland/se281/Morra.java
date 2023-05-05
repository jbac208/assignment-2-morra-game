package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  // Global variables
  private int roundCount = 0;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    roundCount++;
    MessageCli.START_ROUND.printMessage(String.valueOf(roundCount));
  }

  public void showStats() {}
}
