package nz.ac.auckland.se281;

public class MediumStratRunner implements StratRunner {

  private int roundCount;
  private int playerTotalFingers;
  private Game strat = new Game(new RandomStrategy()); // initially use random strat

  public MediumStratRunner(int roundCount, int playerTotalFingers) {
    this.roundCount = roundCount;
    this.playerTotalFingers = playerTotalFingers;
  }

  @Override
  public void runStrat() {
    if (roundCount >= 4) {
      // from 4th round onwards use avg strat
      strat.setStrategy(new AverageStrategy(roundCount, playerTotalFingers)); // pass params
    }
    strat.chooseFingersAndSum();
  }

  @Override
  public int getFingers() {
    return strat.getFingers();
  }

  @Override
  public int getSum() {
    return strat.getSum();
  }
}
