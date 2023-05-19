package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  // Global variables
  private int roundCount = 0;
  private int playerTotalFingers = 0;
  private String userName;
  private final String aiName = "Jarvis";
  private int pointsToWin;
  private Difficulty difficulty;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    this.difficulty = difficulty;
    this.userName = options[0];
    this.pointsToWin = pointsToWin;

    // Print welcome message
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
    // Print player hand info
    MessageCli.PRINT_INFO_HAND.printMessage(userName, userFingers, userSum);

    // Implement Jarvis (Factory design pattern)
    StratRunner stratRunner = GameFactory.createGame(difficulty);
    stratRunner.runStrat(); // runs finger and sum guessing

    // Print ai hand info
    MessageCli.PRINT_INFO_HAND.printMessage(
        aiName, Integer.toString(stratRunner.getFingers()), Integer.toString(stratRunner.getSum()));

    printRoundSummary(
        Integer.parseInt(userFingers),
        Integer.parseInt(userSum),
        stratRunner.getFingers(),
        stratRunner.getSum());

    // Increment total player fingers at round termination
    playerTotalFingers++;
  }

  private void printRoundSummary(int pFingers, int pSum, int jarvisFingers, int jarvisSum) {
    // param sums are the guesses of player & jarvis
    int finalSum = pFingers + jarvisFingers;
    if (pSum == finalSum && jarvisSum == finalSum) {
      // both corrct (draw)
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    } else if (pSum == finalSum) {
      // p win
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    } else if (jarvisSum == finalSum) {
      // jarvis win
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    } else {
      // both wrong (draw)
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
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

  public int getRoundCount() {
    return roundCount;
  }

  public int getPlayerTotalFingers() {
    return playerTotalFingers;
  }

  public void showStats() {}
}
