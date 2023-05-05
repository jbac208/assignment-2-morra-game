package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  // Global variables
  private int roundCount = 0;
  private String userName;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    userName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(userName);
  }

  public void play() {
    roundCount++; // Iterate roundCount
    MessageCli.START_ROUND.printMessage(Integer.toString(roundCount)); // Pretty print roundCount

    // Initialise user input variables
    int userFingers = -1;
    int userSum = -1;
    // Get valid user input
    while (!(userFingers >= 1 && userFingers <= 5 && userSum >= 1 && userSum <= 10)) {
      // Get input
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();
      // Try assign input values
      try {
        userFingers = Integer.parseInt(input.substring(0, input.indexOf(" ")));
        userSum = Integer.parseInt(input.substring(input.indexOf(" ") + 1));
        if (!(userFingers >= 1 && userFingers <= 5 && userSum >= 1 && userSum <= 10)) {
          MessageCli.INVALID_INPUT.printMessage();
        }
      }
      catch (Exception e) {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }
    MessageCli.PRINT_INFO_HAND.printMessage(
        userName, Integer.toString(userFingers), Integer.toString(userSum));
  }

  public void showStats() {}
}
