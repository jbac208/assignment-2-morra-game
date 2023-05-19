package nz.ac.auckland.se281;

public class Game {
  private Strategy strategy;
  private int fingers;
  private int sum;

  public Game(Strategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public void play() {
    this.fingers = strategy.chooseAndGetFingers();
    this.sum = strategy.chooseAndGetSum(this.fingers);
  }

  public int getFingers() {
    return this.fingers;
  }

  public int getSum() {
    return this.sum;
  }
}
