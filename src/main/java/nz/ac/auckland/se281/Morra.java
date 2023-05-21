package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  // Global variables
  private int roundCount;
  // Array list of history of user finger vals
  private ArrayList<Integer> playerFingersArrayList = new ArrayList<Integer>();
  // Other variables
  private String userName;
  private final String aiName = "Jarvis";
  private int pointsToWin;
  private Difficulty difficulty;

  // points variables
  private int userPoints;
  private int aiPoints;

  // game status
  private boolean inGame = false;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    this.difficulty = difficulty;
    this.userName = options[0];
    this.pointsToWin = pointsToWin;

    // Reset every newGame
    this.playerFingersArrayList.clear();
    this.roundCount = 0;
    this.userPoints = 0;
    this.aiPoints = 0;
    this.inGame = true;

    // Print welcome message
    MessageCli.WELCOME_PLAYER.printMessage(userName);
  }

  public void play() {
    if (inGame) {
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
      StratRunner stratRunner =
          GameFactory.createGame(difficulty, roundCount, playerFingersArrayList);
      stratRunner.runStrat(); // runs finger and sum guessing

      // Print ai hand info
      MessageCli.PRINT_INFO_HAND.printMessage(
          aiName,
          Integer.toString(stratRunner.getFingers()),
          Integer.toString(stratRunner.getSum()));

      printRoundsummary(
          Integer.parseInt(userFingers),
          Integer.parseInt(userSum),
          stratRunner.getFingers(),
          stratRunner.getSum());

      // Add player finger to history of userFingers
      playerFingersArrayList.add(Integer.parseInt(userFingers));

      // Check if endGame
      if (isGameOver()) {
        // Print who won, and end game
        if (userPoints == pointsToWin) {
          // player won
          MessageCli.END_GAME.printMessage(userName, Integer.toString(roundCount));

        } else {
          MessageCli.END_GAME.printMessage(aiName, Integer.toString(roundCount));
        }
        inGame = false; // end the game
      }

    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  private boolean isGameOver() {
    if (userPoints == pointsToWin || aiPoints == pointsToWin) {
      return true;
    }
    return false;
  }

  private void printRoundsummary(int pFingers, int pSum, int jarvisFingers, int jarvisSum) {
    // param sums are the guesses of player & jarvis
    int finalSum = pFingers + jarvisFingers;
    if (pSum == finalSum && jarvisSum == finalSum) {
      // both corrct (draw)
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    } else if (pSum == finalSum) {
      // p win
      userPoints++;
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    } else if (jarvisSum == finalSum) {
      // jarvis win
      aiPoints++;
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    } else {
      // both wrong (draw)
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
  }

  private boolean isInputvalid(String input) {
    // determines validity of userInput based off given criteria
    int userFingers;
    int userSum;
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

  public void showStats() {
    if (inGame) {
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          userName, Integer.toString(userPoints), Integer.toString(pointsToWin - userPoints));
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          aiName, Integer.toString(aiPoints), Integer.toString(pointsToWin - aiPoints));
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }
}
