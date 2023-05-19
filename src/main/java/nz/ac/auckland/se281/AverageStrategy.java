package nz.ac.auckland.se281;

public class AverageStrategy implements Strategy {

  private int roundCount;
  private int playerTotalFingers;

  public AverageStrategy(int roundCount, int playerTotalFingers) {
    this.roundCount = roundCount;
    this.playerTotalFingers = playerTotalFingers;
  }

  @Override
  public int chooseFingers() {
    return Utils.getRandomNumber(1, 5);
  }

  @Override
  public int chooseSum(int fingers) {
    int averageFingers =
        calculateAverageFingers(); // Calculate the average of human player's fingers
    return fingers + averageFingers; // Return the sum of AI's fingers and the average
  }

  private int calculateAverageFingers() {
    return Math.round(
        (float) playerTotalFingers
            / roundCount); // Calculate and return the average (rounded to the nearest integer)
  }
}
