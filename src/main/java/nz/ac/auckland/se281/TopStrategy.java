package nz.ac.auckland.se281;

public class TopStrategy implements Strategy {

  private int roundCount;
  private int playerTotalFingers;

  public TopStrategy(int roundCount, int playerTotalFingers) {
    this.roundCount = roundCount;
    this.playerTotalFingers = playerTotalFingers;
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
    // Calculate the average of human player's fingers
    return Math.round((float) playerTotalFingers / (roundCount - 1));
  }
}