package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {
  private int fingers;
  private int sum;

  @Override
  public void chooseFingers() {
    fingers = Utils.getRandomNumber(1, 5);
  }

  @Override
  public void chooseSum() {
    sum = Utils.getRandomNumber(fingers + 1, fingers + 5);
  }

  @Override
  public void play() {
    
  }

  @Override
  public int getFingers() {
    return fingers;
  }

  @Override
  public int getSum() {
    return sum;
  }
}
