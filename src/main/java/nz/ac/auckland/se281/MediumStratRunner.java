package nz.ac.auckland.se281;
import java.util.ArrayList;

public class MediumStratRunner implements StratRunner {

  private int roundCount;
  private ArrayList<Integer> playerFingersArrayList;
  private Game strat = new Game(new RandomStrategy()); // initially use random strat

  public MediumStratRunner(int roundCount, ArrayList<Integer> playerFingersArrayList) {
    this.roundCount = roundCount;
    this.playerFingersArrayList = playerFingersArrayList;
  }

  @Override
  public void runStrat() {
    if (roundCount >= 4) {
      // from 4th round onwards use avg strat
      strat.setStrategy(new AverageStrategy(roundCount, playerFingersArrayList)); // pass params
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
