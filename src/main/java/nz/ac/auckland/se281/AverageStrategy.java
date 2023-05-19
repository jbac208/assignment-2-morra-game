package nz.ac.auckland.se281;

public class AverageStrategy implements Strategy {

  @Override
  public int chooseFingers() {
    return Utils.getRandomNumber(1, 5);
  }

  @Override
    public int chooseSum(int fingers) {
        int averageFingers = calculateAverageFingers(); // Calculate the average of human player's fingers
        return fingers + averageFingers; // Return the sum of AI's fingers and the average
    }

    private int calculateAverageFingers() {
        // Implement your logic to calculate the average of human player's fingers
        // You can access the necessary information from the Morra game instance or any other relevant data source
        // Here's a basic example assuming you have access to the Morra game instance:
        int totalFingers = Morra.getHumanTotalFingers(); // Assuming there's a method to get the total fingers played by the human player
        int roundCount = Morra.getRoundCount(); // Assuming there's a method to get the round count
        if (roundCount == 0) {
            return 0; // Return 0 if no rounds have been played (to avoid division by zero)
        }
        return Math.round((float) totalFingers / roundCount); // Calculate and return the average (rounded to the nearest integer)
    }

}
