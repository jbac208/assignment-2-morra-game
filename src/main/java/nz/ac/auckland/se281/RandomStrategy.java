package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public int chooseAndGetFingers() {
    return Utils.getRandomNumber(1, 5);
  }

  @Override
  public int chooseAndGetSum(int fingers) {
    return Utils.getRandomNumber(fingers + 1, fingers + 5);
  }
}
