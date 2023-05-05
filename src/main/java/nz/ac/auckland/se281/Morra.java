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

    // Initialise user input
    String input = "";
    // Loop until got valid user input
    while (!isInputvalid(input)) {
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
      // If invalid input, print error message
      if (!isInputvalid(input)) {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }

    // Assign valid inputs
    String userFingers = input.substring(0, input.indexOf(" "));
    String userSum = input.substring(input.indexOf(" ") + 1);
    // Print info
    MessageCli.PRINT_INFO_HAND.printMessage(userName, userFingers, userSum);
  }

  private boolean isInputvalid(String input) {
    // determines validity of userInput based off given criteria
    int userFingers = -1;
    int userSum = -1;
    try {
      userFingers = Integer.parseInt(input.substring(0, input.indexOf(" ")));
      userSum = Integer.parseInt(input.substring(input.indexOf(" ") + 1));
      if (!(userFingers >= 1 && userFingers <= 5 && userSum >= 1 && userSum <= 10)) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  public void showStats() {}
}
