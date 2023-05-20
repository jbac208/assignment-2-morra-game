package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Difficulty;

public class GameFactory {

  public static StratRunner createGame(
      Difficulty difficulty, int roundCount, ArrayList<Integer> playerFingersArrayList) {

    switch (difficulty) {
      case EASY:
        return new EasyStratRunner();

      case MEDIUM:
        return new MediumStratRunner(roundCount, playerFingersArrayList);

      case HARD:
        return new HardStratRunner(roundCount, playerFingersArrayList);

      case MASTER:
        return new MasterStratRunner(roundCount, playerFingersArrayList);
    }
    return null;
  }
}
