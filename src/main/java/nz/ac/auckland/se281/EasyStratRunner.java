package nz.ac.auckland.se281;

public class EasyStratRunner implements StratRunner {

  private Game easyStrat = new Game(new RandomStrategy());

  @Override
  public void runStrat() {
    easyStrat.chooseFingersAndSum();
  }

  @Override
  public int getFingers() {
    return easyStrat.getFingers();
  }

  @Override
  public int getSum() {
    return easyStrat.getSum();
  }
}
