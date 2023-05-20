package nz.ac.auckland.se281;

import java.util.ArrayList;

public class AverageStrategy implements Strategy {

  private int roundCount;
  private ArrayList<Integer> playerFingersArrayList;

  public AverageStrategy(int roundCount, ArrayList<Integer> playerFingersArrayList) {
    this.roundCount = roundCount;
    this.playerFingersArrayList = playerFingersArrayList;
  }

  @Override
  public int chooseFingers() {
    return Utils.getRandomNumber(1, 5);
  }

  @Override
  public int chooseSum(int fingers) {
    int averageFingers = calculateAverageFingers();
    return fingers + averageFingers; // Return the sum of AI's fingers and the average
  }

  private int calculateAverageFingers() {
    // Calculate the sum of all integers in the ArrayList
    int playerTotalFingers = 0;
    for (Integer num : playerFingersArrayList) {
      playerTotalFingers += num;
    }
    // Calculate the average of human player's fingers
    return Math.round((float) playerTotalFingers / (roundCount - 1));
  }
}
