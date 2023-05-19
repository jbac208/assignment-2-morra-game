package nz.ac.auckland.se281;

public class AverageStrategy implements Strategy {

  @Override
  public int chooseFingers() {
    return Utils.getRandomNumber(1, 5);
  }

  @Override
  public int chooseSum(int fingers) {
    return fingers;
  }
}
